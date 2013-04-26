package com.yinzhi.eduplat.web.teaching;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yinzhi.eduplat.common.SystemVariableUtils;
import com.yinzhi.eduplat.constant.EduplatContextConstant;
import com.yinzhi.eduplat.entity.account.User;
import com.yinzhi.eduplat.entity.finance.Assignment;
import com.yinzhi.eduplat.entity.finance.Assignqus;
import com.yinzhi.eduplat.entity.finance.Chapter;
import com.yinzhi.eduplat.entity.finance.CorAsm;
import com.yinzhi.eduplat.entity.finance.CorCwr;
import com.yinzhi.eduplat.entity.finance.Course;
import com.yinzhi.eduplat.entity.finance.Courseware;
import com.yinzhi.eduplat.entity.finance.Qustmp;
import com.yinzhi.eduplat.entity.finance.StuAsm;
import com.yinzhi.eduplat.entity.finance.Student;
import com.yinzhi.eduplat.entity.finance.Teacher;
import com.yinzhi.eduplat.service.teaching.TeachingManager;
import com.yinzhi.eduplat.service.teaching.TestingManager;
import com.yinzhi.eduplat.util.EduplatCfgUtil;

/**
 * 
 * @author 黄清泉
 * @date 2013-3-17
 */
@Controller
@RequestMapping("/teaching/teacher")
public class TeachingTecController implements EduplatContextConstant{
	
	private final static Logger logger = LoggerFactory.getLogger(TeachingTecController.class);

	@Autowired
	private TeachingManager teachingManager;
	
	@Autowired
	private TestingManager testingManager;
	
	/**
	 * 教师首页
	 * @param couId
	 * @param pageable
	 * @param request
	 * @return
	 */
	@RequestMapping("index")
	public void index(HttpServletRequest request){
		User user = SystemVariableUtils.getCommonVariableModel().getUser();

//		String tecId = "402880e53d95fb0f013d95fb1f69001e";

		Page<Course> coringList = teachingManager.getTeacherCorings(user.getId(), new PageRequest(0,5));
		Page<Course> coredList = teachingManager.getTeacherCoreds(user.getId(), new PageRequest(0,5));
		
		request.setAttribute("coringList", coringList.getContent());
		request.setAttribute("coredList", coredList.getContent());
	}
	
	/**
	 * 个人信息
	 */
	@RequestMapping("myinfo")
	public void myinfo(HttpServletRequest request){
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		// TODO
		request.setAttribute("tec", teachingManager.getTeacher(user.getId()));
	}
	/**
	 * 获取正教班级，分页
	 * @param pageable
	 * @return
	 */
	@RequestMapping("coring")
	public Page<Course> coring(Pageable pageable) {
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		
		return teachingManager.getTeacherCorings(user.getId(), pageable);
	}
	
	/**
	 * 获取已教班级，分页
	 * @param pageable
	 * @return
	 */
	@RequestMapping("cored")
	public Page<Course> cored(Pageable pageable) {
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		
		return teachingManager.getTeacherCoreds(user.getId(), pageable);
	}
	/**
	 * 当前班级（获取班级信息）
	 * @param corId
	 * @param model
	 */
	@RequestMapping("currcor")
	public void currcor(@RequestParam(value = "corId",required=true)String corId, HttpServletRequest request){
		request.setAttribute("cor",teachingManager.getCurrCourse(corId));
	}
	
	/**
	 * 本班学生，分页(获取当前班级所有学生)
	 * @param couId
	 * @param pageable
	 * @param request
	 * @return
	 */
	@RequestMapping("corstu")
	public Page<Student> corstu(@RequestParam(value = "corId",required=false)String corId, Pageable pageable, HttpServletRequest request) {
		request.setAttribute("corId", corId);
		
		return teachingManager.getCurrCorStus(corId, pageable);
	}
	
	/**
	 * 查看学生基本信息
	 * @param request
	 */
	@RequestMapping("stuinfo")
	public void stuinfo(@RequestParam(value = "stuId",required=true)String stuId, HttpServletRequest request) {
		// TODO
		request.setAttribute("stu", teachingManager.getStudent(stuId));
	}
	
	
	
	/**
	 * 当前班级的课件，分页（获取当前班级所有课件）
	 * @param corId
	 * @param pageable
	 * @param request
	 * @return
	 */
	@RequestMapping("corcwr")
	public Page<CorCwr> corcwr(@RequestParam(value = "corId",required=false)String corId, Pageable pageable, HttpServletRequest request) {
		request.setAttribute("corId", corId);
		
		return teachingManager.getCurrCorCwrs(corId, pageable);
	}
	
	/**
	 * 当前班级的作业，分页（获取当前班级所有作业）
	 * @param corId
	 * @param pageable
	 * @param request
	 * @return
	 */
	@RequestMapping("corasm")
	public Page<CorAsm> corasm(@RequestParam(value = "corId",required=false)String corId, Pageable pageable, HttpServletRequest request) {
		request.setAttribute("corId", corId);

		return teachingManager.getCurrCorAsms(corId, pageable);
	}
	
	/**
	 * 创建/编辑班级
	 * @param request
	 */
	@RequestMapping("readCor")
	public String readCor(@RequestParam(value = "id", required = false)String id, Model model){
		// TODO
		
		if (StringUtils.isEmpty(id)) {
			return "teaching/teacher/createCor";
		} else {
			return "teaching/teacher/readCor";
		}
	}
	
	/**
	 * 保存班级信息
	 * @param entity
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("insertCor")
	public String insertCor(Course entity, HttpServletRequest request) {
		String tendDate = request.getParameter("tendDate");
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		entity.setStartDate(new Date());
		try {
			entity.setEndDate(DateUtils.parseDate(tendDate, "dd/MM/yyyy hh:mm:ss"));// 失效日期
		} catch (ParseException e) {
			e.printStackTrace();
		}
		logger.debug("当前用户ID："+user.getId());
		entity.setCorStatus(COR_STATUS_0);// 未关联，已发布
		entity.setTeacher(new Teacher(user.getId()));
		teachingManager.saveCourse(entity);
		
		return "redirect:/teaching/teacher/coring";
	}
	
	//----------课件模块-----------
	/**
	 * 制作/编辑课件
	 * @param request
	 */
	@RequestMapping("readCwr")
	public void readCwr(HttpServletRequest request){
		//TODO 
		String corId = request.getParameter("corId");
		String bokId = teachingManager.getCourse(corId).getBook().getId();
		String chpId = request.getParameter("chpId");
		request.setAttribute("bokId", bokId);
		request.setAttribute("chpId", chpId);
		request.setAttribute("corId", corId);
	}
	
	/**
	 * 获取课件章节列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getChpList", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public String getChpList(HttpServletRequest request) {

		String strJson = "";
		return "[" + strJson + "]";

	}
	
	/**
	 * 制作课件
	 * @param entity
	 * @param chpId
	 * @param corId
	 * @return
	 */
	@RequestMapping(value = "insertCwr", method = RequestMethod.POST)
	public String insertCwr(HttpServletRequest request){
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		String bokId = request.getParameter("bokId");
		String corId = request.getParameter("corId");
		String chpId = request.getParameter("chpId");
		String nodeIds = request.getParameter("nodeIds");
		String tmpId = request.getParameter("tmpId");
		
		logger.debug("章节节点ID列表：" + nodeIds);
		
		return "redirect:/teaching/teacher/corcwr?corId="+corId;
	}
	
	/**
	 * 上传课件
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "uploadCwr", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public String uploadCwr(HttpServletRequest request){
		// TODO 上传课件
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("cwrFile");
		String corId = multipartRequest.getParameter("corId");
		String chpId = multipartRequest.getParameter("chpId");
		String ctxPath = EduplatCfgUtil.getValue(EDUPLAT_RESOURCE_COURSES)
				+ File.separator + corId + File.separator + chpId
				+ File.separator;
		
		logger.debug("上传的课件文件名为："+file.getOriginalFilename());
		logger.debug("课件文件保存的路径为：" + ctxPath + chpId + PPT_FILE_EXT);
		File uploadFile = new File(ctxPath + chpId + PPT_FILE_EXT);
		try {
			FileCopyUtils.copy(file.getBytes(), uploadFile);
		} catch (IOException e) {
			logger.error("上传课件出现异常：" + e);
			e.printStackTrace();
			return EDUPLAT_ACTION_ERROR;
		}
		return EDUPLAT_ACTION_SUCCESS;
	}
	
	/**
	 * 浏览课件
	 * @param cwrId
	 */
	@RequestMapping("reviewCwr")
	public void reviewCwr(@RequestParam("cwrId") String cwrId, HttpServletRequest request){
		// TODO
//		request.setAttribute("entity", teachingManager.getCourseware(cwrId));
		List<String> imgs = new ArrayList<String>();
		for(int i=1; i<5; i++){
			imgs.add("http://localhost:8080/eduimg/resources/imgs/"+cwrId+"/slide-"+i+".png");
		}
		request.setAttribute("imgs",imgs);
	}
	
	/**
	 * 发布课件
	 * @param cwrId
	 * @return
	 */
	@RequestMapping(value = "releaseCwr", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public String releaseCwr(@RequestParam("cwrId") String cwrId){
		// TODO
		try{
			teachingManager.updateCwrStatus(PPT_STATUS_2, cwrId);
		}catch(Exception e){
			return EDUPLAT_ACTION_ERROR;
		}
		return EDUPLAT_ACTION_SUCCESS;
	}
	/**
	 * 读取可共享的班级
	 * @param bokId
	 * @param corId
	 * @param chpId
	 * @param request
	 */
	@RequestMapping("shareCwr")
	public void shareCwr(@RequestParam("corId") String corId, @RequestParam("chpId") String chpId, @RequestParam("cwrId") String cwrId, HttpServletRequest request){
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		String bokId = teachingManager.getCourse(corId).getBook().getId();
		List<Course> cors = teachingManager.getShareCors(bokId, user.getId(), corId);
		request.setAttribute("chpId", chpId);
		request.setAttribute("cwrId", cwrId);
		if(cors.size()>0)
			request.setAttribute("cors", cors);
		else
			request.setAttribute("cors", null);
	}
	
	/**
	 * 共享课件
	 * @param corIds
	 * @param chpId
	 * @param cwrId
	 * @return
	 */
	@RequestMapping("saveShareCwr")
	@ResponseBody
	public String saveShareCwr(@RequestParam("corIds") List<String> corIds, @RequestParam("chpId") String chpId, @RequestParam("cwrId") String cwrId){
		String ctxPath = EduplatCfgUtil.getValue(EDUPLAT_COURSE_PPT);
		
		Courseware cwr = teachingManager.getCourseware(cwrId);
		List<Courseware> cwrs = new ArrayList<Courseware>();
		try {
			for(String corId:corIds){
				Courseware cwrTmp = new Courseware();
				cwrTmp.setName(cwr.getName());
				cwrTmp.setPptType(cwr.getPptType());
				String pptName = UUID.randomUUID().toString() + PPT_FILE_EXT;
				// 拷贝所共享的文件
				FileCopyUtils.copy(new File(ctxPath + cwr.getPptPath()), new File(ctxPath + pptName));
				// 重新生成课件名称
				cwrTmp.setPptPath(pptName);
				cwrTmp.setPptType(0);
				cwrTmp.setViewNum(0);
				cwrTmp.setDownNum(0);
				// 已制作，未发布状态
				cwrTmp.setPptStatus(0);
				cwrTmp.setChapter(new Chapter(chpId));
				List<Course> cors = new ArrayList<Course>();
				cors.add(new Course(corId));
				// 更新【班级-课件关系表】
				cwrTmp.setCourses(cors);
				cwrs.add(cwrTmp);
			}
			teachingManager.saveCoursewares(cwrs);
		} catch (IOException e) {
			logger.debug("共享课件出现异常："+e);
			e.printStackTrace();
		}
		
		return EDUPLAT_ACTION_SUCCESS;
	}

	/**
	 * 下载课件
	 * @param cwrId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("downloadCwr")
	public String downloadCwr(HttpServletRequest request, HttpServletResponse response){
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;
		try {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("UTF-8");
			
			String corId = request.getParameter("corId");
			String chpId = request.getParameter("chpId");
			String ctxPath = EduplatCfgUtil.getValue(EDUPLAT_RESOURCE_COURSES)
					+ File.separator + corId + File.separator + chpId
					+ File.separator;
			
			String downLoadPath = ctxPath + chpId + PPT_FILE_EXT;
			logger.debug("下载的课件："+downLoadPath);
			long fileLength = new File(downLoadPath).length();
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition", "attachment; filename=" + chpId + PPT_FILE_EXT);
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(downLoadPath));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	//-----------作业模块------------
	/**
	 * 布置/编辑作业
	 * @param request
	 */
	@RequestMapping("createAsm")
	public void readAsm(HttpServletRequest request){
		// TODO
		String corId = request.getParameter("corId");
		request.setAttribute("bokId", teachingManager.getCourse(corId).getBook().getId());
		request.setAttribute("corId", corId);
	}
	/**
	 * 获取图书的章节信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getChpsByBokId", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public List<Chapter> getChpsByBokId(HttpServletRequest request){
		String bokId = request.getParameter("bokId");
		return teachingManager.findChpsbyBokId(bokId);
	}
	/**
	 * 按模板出题，计算题
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getQustmpList", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public List<Qustmp> getQustmpList(HttpServletRequest request){
		String bokId = request.getParameter("bokId");
		String chpId = request.getParameter("chpId");
		String queType = request.getParameter("queType");
		logger.debug("图书ID："+bokId+"  章节ID："+chpId);
		Page<Qustmp> pages = testingManager.getQusTmps(Integer.parseInt(queType), bokId, chpId, new PageRequest(0,25));
		logger.debug("当前取到的题目数为："+pages.getContent().size());
		return pages.getContent();
	}
	
	/**
	 * 保存作业信息
	 * @param request
	 */
	@RequestMapping(value = "insertAsm", method = RequestMethod.POST)
	public String insertAsm(Assignment entity, HttpServletRequest request){
		String chpId = request.getParameter("chpId");
		String corId = request.getParameter("corId");
		entity.setAssStatus(ASM_STATUS_0);//未发布
		entity.setChapter(new Chapter(chpId));
		
		List<Course> cors = new ArrayList<Course>();
		cors.add(teachingManager.getCourse(corId));
		entity.setCourses(cors);
		// 写-作业表
		Date now = new Date();
		entity.setStartDate(now);
		entity.setEndDate(DateUtils.addDays(now, 1));
		Assignment _asm = teachingManager.saveAssignment(entity);
		// TODO 处理作业题型信息
		List<Assignqus> quss = new ArrayList<Assignqus>();
		for(int i=0; i<QUS_TYPE_SIZE; i++){
			String qtCheck = request.getParameter("qt_check_"+i);
			logger.debug("本次作业的题型有："+qtCheck);
			if(qtCheck!=null&&qtCheck.equals("true")){
				Assignqus qus = new Assignqus();
				qus.setQueNum(Integer.parseInt(request.getParameter("qt_num_"+i)));
				qus.setQueScore(Integer.parseInt(request.getParameter("qt_score_"+i)));
				qus.setQusType(i);
				qus.setQueKind(Integer.parseInt(request.getParameter("qt_kind_"+i)));
				qus.setQueInfo(request.getParameter("qt_info_"+i));
				qus.setQueOrder(i);
				qus.setAssignment(_asm);
				quss.add(qus);
			}
		}
		teachingManager.saveAssignquss(quss);
		logger.debug("当前课程ID:"+corId);
		return "redirect:/teaching/teacher/corasm?corId="+corId;
	}
	
	/**
	 * 发布作业
	 * @param request
	 */
	@RequestMapping(value = "releaseAsm", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public String releaseAsm(@RequestParam("asmId") String asmId){
		// TODO 
		try{
			logger.debug("发布当前作业ID:"+asmId);
			teachingManager.updateAsmStatus(ASM_STATUS_1, asmId);
			return EDUPLAT_ACTION_SUCCESS;
		}catch(Exception e){
			return EDUPLAT_ACTION_ERROR;
		}
	}
	
	/**
	 * 删除作业，只有已经发布的作业才可以删除，只是逻辑删除，置作业状态为3
	 * @param request
	 */
	@RequestMapping(value = "deleteAsm", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public String deleteAsm(@RequestParam("asmId") String asmId){
		// TODO
		Assignment asm = teachingManager.getAssignment(asmId);
		if(asm!=null&&asm.getAssStatus()==ASM_STATUS_1){
			teachingManager.updateAsmStatus(ASM_STATUS_2, asmId);
			return EDUPLAT_ACTION_SUCCESS;
		}
		return EDUPLAT_ACTION_ERROR;
	}
	
	/**
	 * 预览作业，给教师提供一个作业概览
	 * @param asmId
	 */
	@RequestMapping("reviewAsm")
	public void reviewAsm(@RequestParam("asmId") String asmId, HttpServletRequest request){
		// TODO
		logger.debug("正在浏览作业ID："+asmId);
		request.setAttribute("testpaper", testingManager.reviewAsm(asmId));
	}
	
	/**
	 * 查看所有学生作答情况
	 * @param corId
	 * @param pageable
	 * @return
	 */
	@RequestMapping("viewSam")
	public Page<StuAsm> viewSam(@RequestParam(value = "asmId",required=true)String asmId, Pageable pageable){
		// TODO
		
		return teachingManager.getCurrStuAsms(asmId, pageable);
	}
	
	/**
	 * 查看某个学生作答情况
	 * @param asmId
	 * @param request
	 */
	@RequestMapping("readSam")
	public void readSam(@RequestParam(value = "assId",required=true)String asmId, HttpServletRequest request){
		// TODO 
		
		//return "/teaching/"+assId+ASM_FILE_EXT;
	}
	
	/**
	 * 调整成绩
	 * @param asmId
	 * @param request
	 */
	@RequestMapping(value = "changeMark", method = RequestMethod.POST)
	public void changeMark(HttpServletRequest request){
		// TODO 
		teachingManager.updateAssScore(request.getParameter("assId"), Integer.valueOf(request.getParameter("asmScroe")));
		
	}
	
	/**
	 * 查看成绩单
	 * @param request
	 */
	@RequestMapping("viewMark")
	public void viewMark(HttpServletRequest request){
		// TODO 
		
		
	}
	
	/**
	 * 下载成绩单
	 * @param request
	 */
	@RequestMapping("downloadMark")
	public void downloadMark(HttpServletRequest request){
		// TODO 
		
		
	}
	
}
