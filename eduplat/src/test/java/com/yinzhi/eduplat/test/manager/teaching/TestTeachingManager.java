package com.yinzhi.eduplat.test.manager.teaching;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

import com.yinzhi.eduplat.constant.EduplatContextConstant;
import com.yinzhi.eduplat.entity.finance.Book;
import com.yinzhi.eduplat.entity.finance.Chapter;
import com.yinzhi.eduplat.entity.finance.Course;
import com.yinzhi.eduplat.entity.finance.Courseware;
import com.yinzhi.eduplat.entity.finance.Teacher;
import com.yinzhi.eduplat.service.teaching.TeachingManager;
import com.yinzhi.eduplat.test.manager.ManagerTestCaseSupport;
import com.yinzhi.eduplat.util.RandomUtil;

/**
 * 教学管理
 * @author 黄清泉
 * @date 2013-3-15
 */
public class TestTeachingManager extends ManagerTestCaseSupport implements EduplatContextConstant{
	
	private final static Logger logger = LoggerFactory.getLogger(TestTeachingManager.class);

	@Autowired
	private TeachingManager teachingManager;

	@Test
	@Transactional(readOnly=true)
	public void testGetTeacherByUserId() {
		Teacher teacher = teachingManager.getTeacher("402880e53d95fb0f013d95fb1f69001e");
		assertEquals(teacher.getName(),"教师1");
	}
	
	@Test
	@Transactional(readOnly=true)
	public void testGetTopTeacherCurrCourses() {
		Pageable pageable = new PageRequest(1,5);
		Page<Course> page = teachingManager.getTeacherCorings("402880e53d95fb0f013d95fb1f69001e", pageable);
		assertEquals(page.getTotalElements(), 50);
		assertEquals(page.getTotalPages(), 10);
	}
	
	@Test
	@Transactional(readOnly=true)
	public void testGetTopTeacherPostCourses() {
		Pageable pageable = new PageRequest(1,5);
		Page<Course> page = teachingManager.getTeacherCoreds("402880e53d95fb0f013d95fb1f69001e", pageable);
		assertEquals(page.getTotalElements(), 50);
		assertEquals(page.getTotalPages(), 10);
	}
	
	@Test
	public void testInsertBook(){
		// TODO 录入一本图书
		int i=888;
		Book bok = new Book();
		bok.setName("新编财务会计（第"+i+"版）");
		bok.setBokNo(RandomUtil.getRandomString(2, "u")+RandomUtil.getRandomString(4, "i"));
		bok.setAuthor("李"+i);
		bok.setPublishDate("2012/"+i%12+"/"+i%30);
		bok.setPublisherName(i%2==0?"上海立信会计出版社":"中信出版社");
		bok.setWorkshop("工作室"+i);
		bok.setPrice(i);
		bok.setIsbn(RandomUtil.getRandomString(15, "u"));
		bok.setCategory(i%2==0?"财务/会计":"经济管理");
		bok.setBokPath("/book/"+i+".doc");
		bok.setPicPath("/book/"+i+".jpg");
		bok.setPageNum(i);
		bok.setAuthorInfo("毕业于 "+i+" 大学，长期从事会计教学实践和理论研究");
		bok.setBokInfo("《新编财务会计》已第 "+i+" 次修订");
		bok.setChpNum(i%10+5);
		bok.setPublishYear("2012");
		bok.setBokType(i%2+1);
		bok.setBokDir("目录"+i);
		bok.setBokTag("标签"+i);
		
		int before = countRowsInTable("tb_book");
		teachingManager.saveBook(bok);
		int after = countRowsInTable("tb_book");
		
		assertEquals(before + 1, after);
	}
	
	@Test
	public void testInsertCourse(){
		// TODO 创建班级，并指定教师
		Course cor = new Course();
		cor.setName("888会计学"+RandomUtil.getRandomString(3, "u"));
		cor.setBokKind(1);
		cor.setBokType(1);
		Date now = new Date();
		cor.setStartDate(DateUtils.addYears(now, -1));
		cor.setEndDate(DateUtils.addDays(now, 15));
		//
		Teacher tec = new Teacher();
		tec.setId("402880e53d7db0be013d7db0cea3012c");
		cor.setTeacher(tec);
		teachingManager.saveCourse(cor);
	}
	
	
	@Test
	public void testLinkCorBok(){
		// TODO 为班级指定图书
		Course cor = teachingManager.getCourse("4028830e3d819d70013d819d7c8f0000");
		//
		Book bok = new Book();
		bok.setId("4028830e3d819bef013d819bfaa20000");
		cor.setBook(bok);
		teachingManager.saveCourse(cor);
	}
	
	@Test
	public void testSaveCourseware(){
		// 传过来的参数
		String chpId = "402880e53d7dc2c7013d7dc2d3670000";
		String corId = "402880e53d7dd702013d7dd70e680000";
		Courseware entity = new Courseware();
		entity.setName("测试制作课件");
		
		// 逻辑处理
		String ctxPath = "E://eduplat//course//ppt//";
		
		String pptName = UUID.randomUUID().toString() + PPT_FILE_EXT;
		entity.setPptPath(pptName);
		entity.setPptType(0);
		entity.setViewNum(0);
		entity.setDownNum(0);
		entity.setPptStatus(0);
		entity.setChapter(new Chapter(chpId));
		List<Courseware> cwrs = new ArrayList<Courseware>();
		// TODO 调用课件自动生成模块，生成课件文件
		
		logger.debug("课件保存路径： "+ctxPath + pptName);
		try {
			FileCopyUtils.copy(new File("C:\\Users\\Andy\\Desktop\\演示文稿1.ppt"), new File(ctxPath + pptName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 更新【课件表】
		cwrs.add(teachingManager.saveCourseware(entity));
		// 更新【班级-课件关系表】
		Course cor = teachingManager.getCourse(corId);
		cor.setCoursewares(cwrs);
		teachingManager.saveCourse(cor);
		
	}
	
}
