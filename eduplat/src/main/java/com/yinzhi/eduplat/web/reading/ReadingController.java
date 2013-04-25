package com.yinzhi.eduplat.web.reading;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yinzhi.eduplat.common.SystemVariableUtils;
import com.yinzhi.eduplat.constant.EduplatContextConstant;
import com.yinzhi.eduplat.entity.account.User;
import com.yinzhi.eduplat.entity.finance.Book;
import com.yinzhi.eduplat.entity.finance.Course;
import com.yinzhi.eduplat.entity.reading.Boknote;
import com.yinzhi.eduplat.entity.reading.Bokreplay;
import com.yinzhi.eduplat.entity.reading.Bokstar;
import com.yinzhi.eduplat.entity.reading.Comment;
import com.yinzhi.eduplat.entity.reading.Favorite;
import com.yinzhi.eduplat.entity.reading.Recommend;
import com.yinzhi.eduplat.service.reading.ReadingManager;

/**
 * 悦读书苑控制器类
 * 
 * @author 黄清泉
 * @date 2013-4-6
 */
@Controller
@RequestMapping("/reading")
public class ReadingController implements EduplatContextConstant {

	private final static Logger logger = LoggerFactory.getLogger(ReadingController.class);

	@Autowired
	private ReadingManager readingManager;

	/**
	 * 悦读书苑首页
	 */
	@RequestMapping("index")
	public void index() {
		// TODO 推荐教材、新书速递、最受关注图书榜、热门标签

	}

	/**
	 * 搜索图书， 分页
	 * 
	 * @param keyword
	 * @param pageable
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "bokSearch", method = RequestMethod.POST)
	public Page<Book> bokSearch(
			@RequestParam(value = "keyword", required = true) String keyword,
			Pageable pageable, HttpServletRequest request) {
		// TODO

		request.setAttribute("keyword", keyword);
		return readingManager.bokSearch(keyword, pageable);
	}

	/**
	 * 查看图书详细
	 * 
	 * @param bokId
	 * @param request
	 */
	@RequestMapping(value = "bokinfo")
	public void bokinfo(
			@RequestParam(value = "bokId", required = true) String bokId,
			HttpServletRequest request) {
		// TODO

		request.setAttribute("book", readingManager.bokinfo(bokId));
	}

	/**
	 * 获取图书评分
	 * 
	 * @param bokId
	 * @param request
	 */
	@RequestMapping(value = "bokstar", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public Bokstar bokstar(@RequestParam(value = "bokId", required = true) String bokId,HttpServletRequest request) {
		// TODO 返回值应该是JSON格式
		return readingManager.bokstar(bokId);
	}
	/**
	 * 更新/保存图书评分信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "updateStar", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public Bokstar updateStar(HttpServletRequest request) {
		String bokId = request.getParameter("bokId");
		int starsN = Integer.parseInt(request.getParameter("score"));
		Bokstar star = readingManager.bokstar(bokId);
		if(star==null){
			star = new Bokstar();
		}
		star.setFkBookId(bokId);
		if(starsN==1){
			star.setStars(star.getStars()==null?1:star.getStars()+1);
		}else if(starsN==2){
			star.setStars1(star.getStars1()==null?1:star.getStars1()+1);
		}else if(starsN==3){
			star.setStars2(star.getStars2()==null?1:star.getStars2()+1);
		}else if(starsN==4){
			star.setStars3(star.getStars3()==null?1:star.getStars3()+1);
		}else if(starsN==5){
			star.setStars4(star.getStars4()==null?1:star.getStars4()+1);
		}
		return readingManager.saveBokstar(star);
	}

	/**
	 * 获取图书赞的数目
	 * 
	 * @param bokId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "totalRem", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public String totalRem(
			@RequestParam(value = "bokId", required = true) String bokId,
			HttpServletRequest request) {
		// TODO 返回值应该是text/html格式

		return String.valueOf(readingManager.totalRem(bokId));
	}

	/**
	 * 获取图书书评，分页
	 * 
	 * @param bokId
	 * @param pageable
	 * @param request
	 * @return
	 */
	@RequestMapping("bokcmt")
	public Page<Comment> bokcmt(
			@RequestParam(value = "bokId", required = true) String bokId,
			Pageable pageable, HttpServletRequest request) {
		// TODO

		request.setAttribute("bokId", bokId);
		return readingManager.bokcmt(bokId, pageable);
	}

	/**
	 * 获取图书笔记，分页
	 * 
	 * @param bokId
	 * @param pageable
	 * @param request
	 * @return
	 */
	@RequestMapping("boknte")
	public Page<Boknote> boknte(
			@RequestParam(value = "bokId", required = true) String bokId,
			Pageable pageable, HttpServletRequest request) {
		// TODO

		request.setAttribute("bokId", bokId);
		return readingManager.boknte(bokId, pageable);
	}
	
	/**
	 * 收藏
	 * 
	 * @param bokId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "createFav", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public String createFav(@RequestParam(value = "bokId", required = true) String bokId) {
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		Favorite fav = readingManager.createFav(user.getId(), bokId);
		if (fav != null)
			return EDUPLAT_ACTION_SUCCESS;
		else
			return EDUPLAT_ACTION_ERROR;
	}

	/**
	 * 推荐/赞
	 * 
	 * @param bokId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "createRem", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public String createRem(
			@RequestParam(value = "bokId", required = true) String bokId,
			HttpServletRequest request) {
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		Recommend rem = readingManager.createRem(user.getId(), bokId,
				request.getParameter("content"));
		if (rem != null)
			return EDUPLAT_ACTION_SUCCESS;
		else
			return EDUPLAT_ACTION_ERROR;
	}

	/**
	 * 书评新增页面，【新增/更新】
	 * 
	 * @param cmtId
	 * @return
	 */
	@RequestMapping(value = "readCmt")
	public String readCmt(
			@RequestParam(value = "cmtId", required = false) String cmtId) {

		if (StringUtils.isEmpty(cmtId)) {
			return "reading/createCmt";
		} else {
			return "reading/readCmt";
		}
	}

	/**
	 * 保存书评内容
	 * 
	 * @param bokId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "createCmt", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public String createCmt(
			@RequestParam(value = "bokId", required = true) String bokId,
			HttpServletRequest request) {
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		Comment cmt = readingManager.createCmt(user.getId(), bokId,request.getParameter("title"),
				request.getParameter("content"));
		if (cmt != null)
			return EDUPLAT_ACTION_SUCCESS;
		else
			return EDUPLAT_ACTION_ERROR;
	}

	/**
	 * 笔记新增页面，【新增/更新】
	 * 
	 * @param cmtId
	 * @return
	 */
	@RequestMapping(value = "readNte")
	public String readNte(
			@RequestParam(value = "nteId", required = false) String nteId) {

		if (StringUtils.isEmpty(nteId)) {
			return "reading/createNte";
		} else {
			return "reading/readNte";
		}
	}

	/**
	 * 保存笔记内容
	 * 
	 * @param bokId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "createNte", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public String createNte(
			@RequestParam(value = "bokId", required = true) String bokId,
			HttpServletRequest request) {
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		Boknote nte = readingManager.createNte(user.getId(), bokId,
				request.getParameter("content"),
				request.getParameter("chpName"),
				Integer.valueOf(request.getParameter("pageNo")));
		if (nte != null)
			return EDUPLAT_ACTION_SUCCESS;
		else
			return EDUPLAT_ACTION_ERROR;
	}
	
	/**
	 * 获取书评的回应
	 * @param cmtId
	 * @param pageable
	 * @return
	 */
	@RequestMapping(value = "bokrep")
	public Page<Bokreplay> bokrep(@RequestParam(value = "cmtId", required = true) String cmtId, HttpServletRequest request, Pageable pageable){
		// TODO 
		request.setAttribute("cmtId", cmtId);
		Comment cmt = readingManager.getComment(cmtId);
		request.setAttribute("title", cmt.getTitle());
		request.setAttribute("content", cmt.getContent());
		return readingManager.bokrep(cmtId, pageable);
	}
	
	/**
	 * 写回应
	 * @param cmtId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "createRep", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public String createRep(@RequestParam(value = "cmtId", required = true) String cmtId, HttpServletRequest request){
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		Bokreplay rep = readingManager.createRep(user.getId(), cmtId, request.getParameter("content"));
		if (rep != null)
			return EDUPLAT_ACTION_SUCCESS;
		else
			return EDUPLAT_ACTION_ERROR;
	}
	
	/**
	 * 我的收藏，分页
	 * @param pageable
	 * @return
	 */
	@RequestMapping("myfav")
	public Page<Favorite> myfav(Pageable pageable) {
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		
		return readingManager.myfav(user.getId(), pageable);
	}

	
	/**
	 * 我的笔记，分页
	 * @param pageable
	 * @return
	 */
	@RequestMapping("mynte")
	public Page<Boknote> mynte(Pageable pageable) {
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		
		return readingManager.mynte(user.getId(), pageable);
	}
	
	/**
	 * 我的书评，分页
	 * @param pageable
	 * @return
	 */
	@RequestMapping("mycmt")
	public Page<Comment> mycmt(Pageable pageable) {
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		
		return readingManager.mycmt(user.getId(), pageable);
	}
	
	/**
	 * 我的回应，分页
	 * @param pageable
	 * @return
	 */
	@RequestMapping("myrep")
	public Page<Bokreplay> myrep(Pageable pageable) {
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		
		return readingManager.myrep(user.getId(), pageable);
	}
	
	/**
	 * 删除收藏
	 * @param favId
	 * @return
	 */
	@RequestMapping(value = "deleteFav", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public String deleteFav(@RequestParam(value = "favId", required = true) String favId){
		try{
			readingManager.deleteFav(favId);
			return EDUPLAT_ACTION_SUCCESS;
		}catch(Exception e){
			return EDUPLAT_ACTION_ERROR;
		}
	}
	
	/**
	 * 删除笔记
	 * @param nteId
	 * @return
	 */
	@RequestMapping(value = "deleteNte", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public String deleteNte(@RequestParam(value = "nteId", required = true) String nteId){
		try{
			readingManager.updateNteStatus(nteId, NTE_STATUS_2);
			return EDUPLAT_ACTION_SUCCESS;
		}catch(Exception e){
			return EDUPLAT_ACTION_ERROR;
		}
	}
	
	/**
	 * 删除书评
	 * @param cmtId
	 * @return
	 */
	@RequestMapping(value = "deleteCmt", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public String deleteCmt(@RequestParam(value = "cmtId", required = true) String cmtId){
		try{
			readingManager.updateCmtStatus(cmtId, NTE_STATUS_2);
			return EDUPLAT_ACTION_SUCCESS;
		}catch(Exception e){
			return EDUPLAT_ACTION_ERROR;
		}
	}
	
	/**
	 * 删除回应
	 * @param repId
	 * @return
	 */
	@RequestMapping(value = "deleteRep", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public String deleteRep(@RequestParam(value = "repId", required = true) String repId){
		try{
			readingManager.updateRepStatus(repId, NTE_STATUS_2);
			return EDUPLAT_ACTION_SUCCESS;
		}catch(Exception e){
			return EDUPLAT_ACTION_ERROR;
		}
	}
	
}
