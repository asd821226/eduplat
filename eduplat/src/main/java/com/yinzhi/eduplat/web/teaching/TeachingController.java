package com.yinzhi.eduplat.web.teaching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yinzhi.eduplat.common.SystemVariableUtils;
import com.yinzhi.eduplat.service.teaching.TeachingManager;

/**
 * 财经人控制器
 * 
 * @author 黄清泉
 * @date 2013-3-17
 */
@Controller
@RequestMapping("/teaching")
public class TeachingController {

	@Autowired
	private TeachingManager teachingManager;

	/**
	 * 财经人首页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("index")
	public String myIndex() {
		if (SystemVariableUtils.hasRole("teacher")) {
			// TODO 教师首页
			return "redirect:teacher/index";
		} else {
			// TODO 学生首页
			return "redirect:student/index";
		}
	}

}
