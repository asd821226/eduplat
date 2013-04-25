package com.yinzhi.eduplat.service.teaching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.exitsoft.orm.core.PropertyFilter;
import org.exitsoft.orm.core.PropertyFilters;
import org.exitsoft.orm.core.spring.data.jpa.specification.Specifications;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.yinzhi.eduplat.constant.EduplatContextConstant;
import com.yinzhi.eduplat.dao.finance.AssignmentDao;
import com.yinzhi.eduplat.dao.finance.AssignqusDao;
import com.yinzhi.eduplat.dao.finance.MyassignDao;
import com.yinzhi.eduplat.dao.finance.QuestionsDao;
import com.yinzhi.eduplat.dao.finance.QustmpDao;
import com.yinzhi.eduplat.dao.finance.TestpaperDao;
import com.yinzhi.eduplat.entity.finance.Assignment;
import com.yinzhi.eduplat.entity.finance.Assignqus;
import com.yinzhi.eduplat.entity.finance.Myassign;
import com.yinzhi.eduplat.entity.finance.Questions;
import com.yinzhi.eduplat.entity.finance.Qustmp;
import com.yinzhi.eduplat.entity.finance.Student;
import com.yinzhi.eduplat.entity.finance.Testpaper;
import com.yinzhi.eduplat.module.assignment.beans.AbstractQue;
import com.yinzhi.eduplat.module.assignment.beans.RandomQue;
import com.yinzhi.module.slides.util.NumberUtils;
import com.yinzhi.module.slides.util.QuestionUtils;

/**
 * 作业核心模块
 * @author 黄清泉
 * @date 2013-4-3
 */
@Service
@Transactional
public class TestingManager implements EduplatContextConstant{
	
	private final static Logger logger = LoggerFactory.getLogger(TestingManager.class);

	// 作业数据访问
	@Autowired
	private AssignmentDao assignmentDao;
	// 学生的作业数据访问
	@Autowired
	private MyassignDao myassignDao;
	// 作业的题型数据访问
	@Autowired
	private AssignqusDao assignqusDao;
	// 学生卷子表数据访问
	@Autowired
	private TestpaperDao testpaperDao;
	// 题库，按模板出题方式数据访问
	@Autowired
	private QustmpDao qustmpDao;
	// 题库，按随机出题方式数据访问
	@Autowired
	private QuestionsDao questionsDao;
	
	/**
	 * 预览作业模块
	 * @param asmId
	 */
	public String reviewAsm(String asmId){
		return this.buildAsm(asmId);
	}
	
	/**
	 * 学生回顾卷子
	 * @param asmId 作业ID
	 * @param assId 学生作业ID
	 * @return
	 */
	public String readAss(String asmId, String stuId){
		List<Myassign> asss = myassignDao.getCurrAss(asmId, stuId);
		if(asss!=null&&asss.size()>0)
			return this.buildAsm(asmId, true, asss.get(0));
		return null;
	}
	
	/**
	 * 学生作答的卷子
	 * @param asmId 作业ID
	 * @param stuId 学生ID
	 * @return
	 */
	public String startAsm(String asmId, String stuId){
		List<Myassign> assigns = myassignDao.getCurrAss(asmId, stuId);
		Myassign ass = null;
		if(assigns!=null&&assigns.size()>0){
			ass = assigns.get(0);
		}else{
			ass = new Myassign();
			ass.setAssignment(new Assignment(asmId));
			ass.setStudent(new Student(stuId));
			ass.setAssScore(0);
		}
		ass.setMssStatus(MSS_STATUS_1); //已出卷，未作答
		return this.buildAsm(asmId, false, myassignDao.save(ass));
	}
	
	/**
	 * 判卷模块
	 * @param assId
	 * @param answers
	 */
	public void submitAss(String assId, Map answers){
		int totalScore = 0;
		List<Testpaper> papers = testpaperDao.getTestpapersByAssId(assId);
		for(Testpaper paper:papers){
			Object _answer = answers.get(paper.getId());
			if(_answer!=null){
				String[] _answers = (String[])_answer;
				paper.setAnswer(_answers[0]);
			}
			int currScore = this.judgeAss(paper);
			paper.setQueScore(currScore);
			totalScore+=currScore;
		}
		testpaperDao.save(papers);// 更新【学生卷子表】该题得分情况
		myassignDao.save(new Myassign(assId, totalScore));// 更新【学生作业表】总得分
	}
	/**
	 * 判卷核心模块
	 * 真实分数=当前给分×每小题分数/100
	 * @param assId
	 * @param paper
	 * @return
	 */
	private int judgeAss(Testpaper paper){
		int qusKind = paper.getQueKind();
		if(qusKind==QUS_KIND_0){
			Questions que = questionsDao.findOne(paper.getFkQueId());//这个查询效率需要调优
			if(que.getAnswer().equals(paper.getAnswer().trim()))
				return 100;
		}else if(qusKind==QUS_KIND_1){
			// TODO 按模板出题方式评分算法
			
			return 0;
		}else if(qusKind==QUS_KIND_2){
			// TODO 按业务点出题方式评分算法
			
			return 0;
		}
		
		return 0;
	}
	/**
	 * 教师浏览卷子
	 * @param asmId
	 * @return
	 */
	private String buildAsm(String asmId){
		StringBuffer sf = new StringBuffer();
		Assignment asm = assignmentDao.findOne(asmId);
		List<Assignqus> quss = asm.getAssignquss();
		// TODO 调用出题模块
		List<AbstractQue> aques= this.buildQus(quss);
		int step = 0;// 计数器
		for(int t=0; t<quss.size(); t++){
			Assignqus qus = quss.get(t);
			int qusNum = qus.getQueNum();
			sf.append("<h3 class='que-type'>"+NumberUtils.numberArab2CN(t+1)+"、"+QuestionUtils.getCnType(qus.getQusType())+"</h3>");
			for(int i=0; i<qusNum; i++){
				sf.append("    ");
				AbstractQue _aque = aques.get(step++);
				// TODO 将题目从XML格式转为HTML格式
				sf.append("<p class='que-cnt'>"+(i+1)+"、"+_aque.getContent()+"</p>");// 暂时还没做转化
			}
		}
		return sf.toString();
	}
	
	/**
	 * 生成卷子模块
	 * @param asmId
	 * @param onlyView true--已作答，false--未作答
	 * @param ass 学生作业
	 * @return
	 */
	private String buildAsm(String asmId, boolean onlyView, Myassign ass){
		StringBuffer sf = new StringBuffer();
		List<Testpaper> papers = new ArrayList<Testpaper>();
		Assignment asm = assignmentDao.findOne(asmId);
		List<Assignqus> quss = asm.getAssignquss();
		// TODO 调用出题模块
		List<AbstractQue> aques= this.buildQus(quss);
		int step = 0;// 计数器
		for(Assignqus qus:quss){
			int qusNum = qus.getQueNum();
			for(int i=0; i<qusNum; i++){
				sf.append("    ");
				AbstractQue _aque = aques.get(step++);
				if(!onlyView){
					Testpaper paper = new Testpaper();
					paper.setContent(_aque.getContent());
//					paper.setAnswer(_aque.getAnswer());// 应该是学生的答案，待修改
					paper.setQueKind(qus.getQueKind());
					paper.setQueScore(0);// 初始化得分为0分
					paper.setQusType(qus.getQusType());
					paper.setFkQueId(_aque.getId());// 随机出题方式，题目ID
					paper.setMyassign(ass);
					papers.add(paper);
				}
			}
		}
		// 学生作答时，才需要保存【学生卷子表】
		if(!onlyView){
			papers = testpaperDao.save(papers);
		}else{
			papers = ass.getTestpapers();
		}
		step = 0;//清空
		for(int t=0; t<quss.size(); t++){
			Assignqus qus = quss.get(t);
			int qusNum = qus.getQueNum();
			sf.append("<h3 class='que-type'>"+NumberUtils.numberArab2CN(t+1)+"、"+QuestionUtils.getCnType(qus.getQusType())+"</h3>");
			for(int i=0; i<qusNum; i++){
				sf.append("    ");
				AbstractQue _aque = aques.get(step++);
				// TODO 将题目从XML格式转为HTML格式
				sf.append("<p class='que-cnt'>"+(i+1)+"、"+_aque.getContent()+"</p>");// 暂时还没做转化
				Testpaper _paper = papers.get(step-1);
				if(!onlyView||(ass.getMssStatus()!=null&&ass.getMssStatus()==MSS_STATUS_1)){
					sf.append("<p><input type='text' name='");
					sf.append(_paper.getId());
					sf.append("' /></p>");
				}else{
					sf.append("<p class='que-answer'><span>您的回答：</span>  "+_paper.getAnswer()+"</p>");
					sf.append("<p class='que-answer2'><span>标准答案：</span>  "+_aque.getAnswer()+"</p>");
				}
			}
		}
		return sf.toString();
	}
	
	/**
	 * 出题模块
	 * @param quss
	 * @return
	 */
	private List<AbstractQue> buildQus(List<Assignqus> quss){
		List<AbstractQue> aques = new ArrayList<AbstractQue>();
		
		for(Assignqus qus:quss){
			int qusKind = qus.getQueKind();
			String qusInfo = qus.getQueInfo();
			if(qusKind==QUS_KIND_0){
				// 随机出题方式
				List<Questions> ques = (List<Questions>) questionsDao.findAll(Arrays.asList(qusInfo.split(",")));
				for(Questions que:ques){
					aques.add(new RandomQue(que.getId(), que.getContent(), que.getAnswer()));
				}
			}else if(qusKind==QUS_KIND_1){
				// 按模板出题方式
				
			}else if(qusKind==QUS_KIND_2){
				// 按业务点出题方式
				
			}
		}
		return aques;
	}
	
	/**
	 * 获取按模板出题方式的题目
	 * @param qusType 题目类型：5-计算题，6-图表题，7-分录题
	 * @param bokId
	 * @param chpId
	 * @param pageable
	 * @return
	 */
	public Page<Qustmp> getQusTmps(int qusType,String bokId, String chpId, Pageable pageable){
		List<PropertyFilter> filters = Lists.newArrayList(
			    PropertyFilters.build("EQI_qusType", String.valueOf(qusType)),
			    PropertyFilters.build("EQS_fkBokId", bokId),
			    PropertyFilters.build("EQS_fkChpId", chpId)
		);
		return qustmpDao.findAll(Specifications.get(filters), pageable);
	} 
}
