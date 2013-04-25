package com.yinzhi.eduplat.service.finance;

import java.util.List;

import org.exitsoft.orm.core.PropertyFilter;
import org.exitsoft.orm.core.spring.data.jpa.specification.Specifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yinzhi.eduplat.dao.finance.AssignmentDao;
import com.yinzhi.eduplat.dao.finance.AssignqusDao;
import com.yinzhi.eduplat.dao.finance.BookDao;
import com.yinzhi.eduplat.dao.finance.ChapterDao;
import com.yinzhi.eduplat.dao.finance.CourseDao;
import com.yinzhi.eduplat.dao.finance.CoursewareDao;
import com.yinzhi.eduplat.dao.finance.MyassignDao;
import com.yinzhi.eduplat.dao.finance.StudentDao;
import com.yinzhi.eduplat.dao.finance.TeacherDao;
import com.yinzhi.eduplat.entity.finance.Assignment;
import com.yinzhi.eduplat.entity.finance.Assignqus;
import com.yinzhi.eduplat.entity.finance.Book;
import com.yinzhi.eduplat.entity.finance.Chapter;
import com.yinzhi.eduplat.entity.finance.Course;
import com.yinzhi.eduplat.entity.finance.Courseware;
import com.yinzhi.eduplat.entity.finance.Myassign;
import com.yinzhi.eduplat.entity.finance.Student;
import com.yinzhi.eduplat.entity.finance.Teacher;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class FinanceManager {

	//学生数据访问
	@Autowired
	private StudentDao studentDao;
	//教师数据访问
	@Autowired
	private TeacherDao teacherDao;
	//课程数据访问
	@Autowired
	private CourseDao courseDao;
	//图书数据访问
	@Autowired
	private BookDao bookDao;
	//作业数据访问
	@Autowired
	private AssignmentDao assignmentDao;
	//章节数据访问
	@Autowired
	private ChapterDao chapterDao;
	//课件数据访问
	@Autowired
	private CoursewareDao coursewareDao;
	//学生的作业数据访问
	@Autowired
	private MyassignDao myassignDao;
	//作业的题型数据访问
	@Autowired
	private AssignqusDao assignqusDao;
	
	
	//===========Student===========
	public Student getStudent(String id){
		return studentDao.findOne(id);
	}
	
	public Page<Student> searchStudentPage(Pageable pageable,List<PropertyFilter> filters) {
		return studentDao.findAll(Specifications.get(filters), pageable);
	}
	
	public void updateStudent(Student entity) {
		studentDao.save(entity);
	}
	
	public void deleteStudents(List<String> ids) {
		studentDao.delete(studentDao.findAll(ids));
	}
	
	
	//===========Teacher===========
	
	public Page<Teacher> searchTeacherPage(Pageable pageable,List<PropertyFilter> filters) {
		return teacherDao.findAll(Specifications.get(filters), pageable);
	}
	
	
	
	//===========Course===========
	
	public Page<Course> searchCoursePage(Pageable pageable,List<PropertyFilter> filters) {
		return courseDao.findAll(Specifications.get(filters), pageable);
	}
	
	
	//===========Book===========
	
	public Page<Book> searchBookPage(Pageable pageable,List<PropertyFilter> filters) {
		return bookDao.findAll(Specifications.get(filters), pageable);
	}
	
	
	//===========Chapter===========
	
	public Page<Chapter> searchChapterPage(Pageable pageable,List<PropertyFilter> filters) {
		return chapterDao.findAll(Specifications.get(filters), pageable);
	}
	
	
	//===========Assignment===========
	
	public Page<Assignment> searchAssignmentPage(Pageable pageable,List<PropertyFilter> filters) {
		return assignmentDao.findAll(Specifications.get(filters), pageable);
	}
	
	//===========Assignqus===========
	
	public Page<Assignqus> searchAssignqusPage(Pageable pageable,List<PropertyFilter> filters) {
		return assignqusDao.findAll(Specifications.get(filters), pageable);
	}
	
	
	//===========Courseware===========
	
	public Page<Courseware> searchCoursewarePage(Pageable pageable,List<PropertyFilter> filters) {
		return coursewareDao.findAll(Specifications.get(filters), pageable);
	}
	
	
	//===========Myassign===========
	
	public Page<Myassign> searchMyassignPage(Pageable pageable,List<PropertyFilter> filters) {
		return myassignDao.findAll(Specifications.get(filters), pageable);
	}
		
}
