package com.yinzhi.eduplat.web.teaching;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yinzhi.eduplat.common.SystemVariableUtils;
import com.yinzhi.eduplat.constant.EduplatContextConstant;
import com.yinzhi.eduplat.entity.account.User;
import com.yinzhi.eduplat.entity.finance.CorAsm;
import com.yinzhi.eduplat.entity.finance.CorCwr;
import com.yinzhi.eduplat.entity.finance.Course;
import com.yinzhi.eduplat.entity.finance.Student;
import com.yinzhi.eduplat.service.teaching.TeachingManager;
import com.yinzhi.eduplat.service.teaching.TestingManager;

/**
 * 学生角色控制器
 * @author 黄清泉
 * @date 2013-3-26
 */
@Controller
@RequestMapping("/teaching/student")
public class TeachingStuController implements EduplatContextConstant{
	
	private final static Logger logger = LoggerFactory.getLogger(TeachingStuController.class);
	
	@Autowired
	private TeachingManager teachingManager;
	
	@Autowired
	private TestingManager testingManager;
	/**
	 * 学生首页
	 * @param request
	 */
	@RequestMapping("index")
	public void index(HttpServletRequest request){
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		logger.info("学生【"+user.getId()+"】于（"+System.currentTimeMillis()+"）进入财经人。");
		
//		String stuId = "402880e53d95fb0f013d95fb1e0a0000";

		Page<Course> coringList = teachingManager.getStudentCorings(user.getId(), new PageRequest(0,5));
		Page<Course> coredList = teachingManager.getStudentCoreds(user.getId(), new PageRequest(0,5));
		
		request.setAttribute("coringList", coringList.getContent());
		request.setAttribute("coredList", coredList.getContent());
	}
	
	/**
	 * 个人信息
	 */
	@RequestMapping("myinfo")
	public void myinfo(HttpServletRequest request){
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		logger.info("学生【"+user.getId()+"】于（"+System.currentTimeMillis()+"）在查看个人信息。");
		// TODO
		Student stu = teachingManager.getStudent(user.getId());
		request.setAttribute("stu", stu);
	}
	
	/**
	 * 当前班级（获取班级信息）
	 * @param corId
	 * @param model
	 */
	@RequestMapping("currcor")
	public void currcor(@RequestParam(value = "corId",required=true)String corId, HttpServletRequest request){
		// TODO
		logger.info("于（"+System.currentTimeMillis()+"）"+"访问当前班级ID=【"+corId+"】。");
		request.setAttribute("cor",teachingManager.getCurrCourse(corId));
	}
	
	/**
	 * 获取在修课程，分页
	 * @param pageable
	 * @return
	 */
	@RequestMapping("coring")
	public Page<Course> coring(Pageable pageable) {
		// TODO
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		logger.info("学生【"+user.getId()+"】于（"+System.currentTimeMillis()+"）在查看在修课程列表，分页。");
		return teachingManager.getStudentCorings(user.getId(), pageable);
	}
	
	/**
	 * 获取已修课程，分页
	 * @param pageable
	 * @return
	 */
	@RequestMapping("cored")
	public Page<Course> cored(Pageable pageable) {
		// TODO
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		logger.info("学生【"+user.getId()+"】于（"+System.currentTimeMillis()+"）在在查看已修课程列表，分页。");
		return teachingManager.getStudentCoreds(user.getId(), pageable);
	}
	
	
	/**
	 * 获取当前班级所有已发布课件，分页
	 * @param corId
	 * @param pageable
	 * @param request
	 * @return
	 */
	@RequestMapping("corcwr")
	public Page<CorCwr> corcwr(@RequestParam(value = "corId",required=true)String corId, Pageable pageable, HttpServletRequest request) {
		// TODO
		logger.info("于（"+System.currentTimeMillis()+"）"+"访问班级ID=【"+corId+"】的已发布课件列表，发页。");
		request.setAttribute("corId", corId);
		
		return teachingManager.getCurrCorCwrs(corId, pageable);
	}
	
	
	/**
	 * 获取当前班级所有已发布作业，分页
	 * @param corId
	 * @param pageable
	 * @param request
	 * @return
	 */
	@RequestMapping("corasm")
	public Page<CorAsm> corasm(@RequestParam(value = "corId", required=true)String corId, Pageable pageable, HttpServletRequest request) {
		// TODO
		logger.info("于（"+System.currentTimeMillis()+"）"+"访问班级ID=【"+corId+"】的已发布作业列表，发页。");
		request.setAttribute("corId", corId);
		
		return teachingManager.getCurrCorAsms(corId, pageable);
	}
	
	/**
	 * 下载课件
	 * @param cwrId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("downloadCwr")
	public String downloadCwr(@RequestParam(value = "cwrId", required=true) String cwrId, HttpServletRequest request, HttpServletResponse response){
		// TODO
		
		//暂时不开放该功能
		return null;
	}

	
	/**
	 * 浏览课件
	 * @param cwrId
	 */
	@RequestMapping("reviewCwr")
	public void reviewCwr(@RequestParam(value = "cwrId", required = true) String cwrId, HttpServletRequest request){
		// TODO
		logger.info("于（"+System.currentTimeMillis()+"）"+"浏览课件ID=【"+cwrId+"】。");
		
		request.setAttribute("cwrId", cwrId);
	}
	
	/**
	 * 开始作答
	 * @param asmId
	 */
	@RequestMapping("startAsm")
	public void startAsm(@RequestParam(value = "asmId", required = true)String asmId, HttpServletRequest request){
		// TODO
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		logger.info("学生【"+user.getId()+"】于（"+System.currentTimeMillis()+"）"+"开始作答作业ID=【"+asmId+"】。");
		
		request.setAttribute("testpaper", testingManager.startAsm(asmId, user.getId()));
		request.setAttribute("asmId", asmId);
	}
	
	/**
	 * 查看作答情况
	 * @param asmId
	 */
	@RequestMapping("readAss")
	public void readAss(@RequestParam(value = "asmId", required = true)String asmId, HttpServletRequest request){
		// TODO
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		logger.info("学生【"+user.getId()+"】于（"+System.currentTimeMillis()+"）"+"查看已作答作业ID=【"+asmId+"】。");
		
		request.setAttribute("testpaper", testingManager.readAss(asmId, user.getId()));
	}
	
	/**
	 * 提交作答
	 * @param asmId
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("submitAss")
	public void submitAss(@RequestParam(value = "asmId", required = true)String asmId, HttpServletRequest request){
		// TODO
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		logger.info("学生【"+user.getId()+"】于（"+System.currentTimeMillis()+"）"+"提交作答作业ID=【"+asmId+"】。");
		
		testingManager.submitAss(teachingManager.getCurrAss(asmId, user.getId()).getId(), request.getParameterMap());
	}
}
