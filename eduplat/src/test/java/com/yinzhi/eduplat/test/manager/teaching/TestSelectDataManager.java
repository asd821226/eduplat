package com.yinzhi.eduplat.test.manager.teaching;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.yinzhi.eduplat.dao.account.UserDao;
import com.yinzhi.eduplat.dao.finance.AssignmentDao;
import com.yinzhi.eduplat.dao.finance.AssignqusDao;
import com.yinzhi.eduplat.dao.finance.BookDao;
import com.yinzhi.eduplat.dao.finance.ChapterDao;
import com.yinzhi.eduplat.dao.finance.CourseDao;
import com.yinzhi.eduplat.dao.finance.CoursewareDao;
import com.yinzhi.eduplat.dao.finance.MyassignDao;
import com.yinzhi.eduplat.dao.finance.StudentDao;
import com.yinzhi.eduplat.dao.finance.TeacherDao;
import com.yinzhi.eduplat.dao.reading.BokstarDao;
import com.yinzhi.eduplat.entity.finance.Course;
import com.yinzhi.eduplat.test.manager.ManagerTestCaseSupport;

public class TestSelectDataManager extends ManagerTestCaseSupport{

	private final static Logger logger = LoggerFactory.getLogger(TestSelectDataManager.class);
	
	@Autowired
	private UserDao userDao;
	// 学生数据访问
	@Autowired
	private StudentDao studentDao;
	// 教师数据访问
	@Autowired
	private TeacherDao teacherDao;
	// 课程数据访问
	@Autowired
	private CourseDao courseDao;
	// 图书数据访问
	@Autowired
	private BookDao bookDao;
	// 作业数据访问
	@Autowired
	private AssignmentDao assignmentDao;
	// 章节数据访问
	@Autowired
	private ChapterDao chapterDao;
	// 课件数据访问
	@Autowired
	private CoursewareDao coursewareDao;
	// 学生的作业数据访问
	@Autowired
	private MyassignDao myassignDao;
	// 作业的题型数据访问
	@Autowired
	private AssignqusDao assignqusDao;
	
	@Autowired
	private BokstarDao bokstarDao;
	
	
	//----------【学生角色】开始----------
	
	//SELECT c.name FROM tb_student s, tb_student_course sc, tb_course c WHERE c.id = sc.fk_course_id AND sc.fk_student_id = s.id AND s.id =  '402880e53d95fb0f013d95fb1e0a0000' LIMIT 0 , 30
	@Test
	public void testSelectStuCorings(){
		Pageable pageable = new PageRequest(0,10);
		Page<Course> page =  courseDao.getStudentCorings("402880e53d95fb0f013d95fb1e0a0000", pageable);
//		logger.debug("课程对应的图书图片路径为："+page.getContent().get(0).getBokPic());
		assertEquals(page.getNumberOfElements(), 1);
		assertEquals(page.getTotalElements(), 1);
		assertEquals(page.getTotalPages(), 1);
	}
	
	@Test
	public void testSelectStuCoreds(){
		Pageable pageable = new PageRequest(0,10);
		Page<Course> page =  courseDao.getStudentCoreds("402880e53d95fb0f013d95fb1e0a0000", pageable);
		logger.debug("课程对应的图书图片路径为："+page.getContent().get(0).getBokPic());
		assertEquals(page.getNumberOfElements(), 1);
		assertEquals(page.getTotalElements(), 1);
		assertEquals(page.getTotalPages(), 1);
	}
	
//	@Test
//	public void testSelect2(){
//		List<BokTmp> tmps = bokstarDao.test2("402880e53d95fb80013d95fb8eba0000");
//		BokTmp tmp = tmps.get(0);
//		logger.debug("===="+tmp.getStaScore());
//		assertEquals(tmps.size(), 1);
//	}
//	
	
}
