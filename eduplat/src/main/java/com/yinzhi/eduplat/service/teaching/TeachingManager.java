package com.yinzhi.eduplat.service.teaching;

import java.util.List;

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
import com.yinzhi.eduplat.entity.finance.CorAsm;
import com.yinzhi.eduplat.entity.finance.CorCwr;
import com.yinzhi.eduplat.entity.finance.CorTec;
import com.yinzhi.eduplat.entity.finance.Course;
import com.yinzhi.eduplat.entity.finance.Courseware;
import com.yinzhi.eduplat.entity.finance.Myassign;
import com.yinzhi.eduplat.entity.finance.StuAsm;
import com.yinzhi.eduplat.entity.finance.Student;
import com.yinzhi.eduplat.entity.finance.Teacher;

/**
 * 财经人总服务
 * @author 黄清泉
 * @date 2013-4-3
 */
@Service
@Transactional
public class TeachingManager {

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
	
	/**
	 * 获取教师个人信息
	 * @param usrId
	 * @return
	 */
	public Teacher getTeacher(String id) {
		return teacherDao.findOne(id);
	}
	/**
	 * 保存教师信息
	 * @param tec
	 */
	public void saveTeacher(Teacher tec){
		teacherDao.save(tec);
	}

	/**
	 * 获取教师正教班级列表，分页
	 * @param usrId
	 * @return
	 */
	public Page<Course> getTeacherCorings(String usrId, Pageable pageable){
		return courseDao.getTeacherCorings(usrId, pageable);
	}
	
	
	/**
	 * 获取教师已教班级列表，分页
	 * @param usrId
	 * @return
	 */
	public Page<Course> getTeacherCoreds(String usrId, Pageable pageable){
		return courseDao.getTeacherCoreds(usrId, pageable);
	}
	
	/**
	 * 获取学生所有在修课程，分页显示
	 * @param usrId
	 * @param pageable
	 * @return
	 */
	public Page<Course> getStudentCorings(String usrId, Pageable pageable){
		return courseDao.getStudentCorings(usrId, pageable);
	}
	
	/**
	 * 获取学生所有已修课程，分页显示
	 * @param usrId
	 * @param pageable
	 * @return
	 */
	public Page<Course> getStudentCoreds(String usrId, Pageable pageable){
		return courseDao.getStudentCoreds(usrId, pageable);
	}
	
	
	/**
	 * 获取班级信息，学生
	 * @param id 班级ID
	 * @return
	 */
	public Course getCourse(String id){
		return courseDao.findOne(id);
	}
	/**
	 * 获取班级信息，教师
	 * @param id
	 * @return
	 */
	public CorTec getCurrCourse(String id){
		return courseDao.getCurrCourse(id);
	}
	/**
	 * 获取班级集合
	 * @param ids
	 * @return
	 */
	public List<Course> getCourses(List<String> ids){
		return (List<Course>) courseDao.findAll(ids);
	}
	
	/**
	 * 获取当前班级所有学生列表
	 * @param id 班级ID
	 * @param pageable
	 * @return
	 */
	public Page<Student> getCurrCorStus(String id, Pageable pageable){
		return courseDao.getCurrCorStus(id, pageable);
	}
	/**
	 * 获取当前班级所有课件列表
	 * @param id 班级ID
	 * @param pageable
	 * @return
	 */
	public Page<CorCwr> getCurrCorCwrs(String id, Pageable pageable){
		return courseDao.getCurrCorCwrs(id, pageable);
	}

	/**
	 * 获取当前班级所有作业列表
	 * @param id 班级ID
	 * @param pageable
	 * @return
	 */
	public Page<CorAsm> getCurrCorAsms(String id, Pageable pageable){
		return courseDao.getCurrCorAsms(id, pageable);
	}
	
	/**
	 * 获取作业的学生答题情况
	 * @param id
	 * @param pageable
	 * @return
	 */
	public Page<StuAsm> getCurrStuAsms(String id, Pageable pageable){
		return assignmentDao.getCurrStuAsms(id, pageable);
	}
	/**
	 * 创建班级
	 * @param entity
	 */
	public void saveCourse(Course entity){
		courseDao.save(entity);
	}
	
	
	/**
	 * 获取图书
	 * @param id
	 * @return
	 */
	public Book getBook(String id){
		return bookDao.findOne(id);
	}
	
	/**
	 * 录入图书
	 * @param entity
	 */
	public void saveBook(Book entity){
		bookDao.save(entity);
	}
	
	/**
	 * 获取图书的章节信息
	 * @param bokId
	 * @return
	 */
	public List<Chapter> findChpsbyBokId(String bokId){
		return chapterDao.findChpsbyBokId(bokId);
	}
	
	/**
	 * 制作课件
	 * @param entity
	 * @return
	 */
	public Courseware saveCourseware(Courseware entity){
		return coursewareDao.save(entity);
	}
	
	/**
	 * 更新多个课件
	 * @param entitys
	 * @return
	 */
	public List<Courseware> saveCoursewares(List<Courseware> entitys){
		return coursewareDao.save(entitys);
	}
	
	/**
	 * 获取课件
	 * @param id
	 * @return
	 */
	public Courseware getCourseware(String id){
		return coursewareDao.findOne(id);
	}
	/**
	 * 获取可共享的班级
	 * @param bokId
	 * @param tecId
	 * @param corId
	 * @return
	 */
	public List<Course> getShareCors(String bokId, String tecId, String corId){
		return courseDao.getShareCors(bokId, tecId, corId);
	}
	
	/**
	 * 更新课件状态
	 * @param status
	 * @param cwrId
	 * @return
	 */
	public int updateCwrStatus(int status, String cwrId){
		return coursewareDao.updateStatus(status, cwrId);
	}
	
	/**
	 * 布置作业，写作业题型表
	 * @param entity
	 * @return
	 */
	public Assignment saveAssignment(Assignment entity){
		return assignmentDao.save(entity);
	}
	
	/**
	 * 布置作业，写作业题型表
	 * @param entities
	 */
	public void saveAssignquss(List<Assignqus> entities){
		assignqusDao.save(entities);
	}
	
	/**
	 * 发布作业
	 * @param status
	 * @param asmId
	 * @return
	 */
	public int updateAsmStatus(int status, String asmId){
		return assignmentDao.updateStatus(status, asmId);
	}
	
	/**
	 * 删除作业，此方法有待调整，需要考虑到同时删除学生已经作答的作业
	 * @param asmId
	 */
	public void deleteAsm(String asmId){
		// TODO
		assignmentDao.delete(asmId);
	}
	
	/**
	 * 获取作业信息
	 * @param asmId
	 * @return
	 */
	public Assignment getAssignment(String asmId){
		return assignmentDao.findOne(asmId);
	}
	
	/**
	 * 获取学生作业
	 * @param asmId 作业ID
	 * @param stuId 学生ID
	 * @return
	 */
	public Myassign getCurrAss(String asmId, String stuId){
		List<Myassign> asss = myassignDao.getCurrAss(asmId, stuId);
		if(asss!=null&&asss.size()>0)
			return asss.get(0);
		return null;
	}
	
	/**
	 * 调整成绩
	 * @param assId
	 * @param assScore
	 * @return
	 */
	public Myassign updateAssScore(String assId, int assScore){
		Myassign ass = new Myassign(assId, assScore);
		return myassignDao.save(ass);
	}
	
	
	//-----------学生角色------------
	/**
	 * 获取学生信息
	 * @param stuId
	 * @return
	 */
	public Student getStudent(String stuId){
		return studentDao.findOne(stuId);
	}
	
	/**
	 * 预览作业模块
	 * @param asmId
	 */
	public void reviewAsm(String asmId){
		
	}
	
	
	/**
	 * 生成卷子模块
	 * @return
	 */
	public String buildAsm(){
		
		return null;
	}
}
