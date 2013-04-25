package com.yinzhi.eduplat.test.manager.teaching;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.yinzhi.eduplat.common.enumeration.entity.State;
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
import com.yinzhi.eduplat.entity.account.User;
import com.yinzhi.eduplat.entity.finance.Assignment;
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
import com.yinzhi.eduplat.test.manager.ManagerTestCaseSupport;
import com.yinzhi.eduplat.util.RandomUtil;

public class TestInitDataManager extends ManagerTestCaseSupport{

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
	
	
	
	@Test
	public void testInsertUser() {
		// TODO 初始化31个用户
		List<User> lst = new ArrayList<User>();
		for(int i=1; i<=31; i++){
			User entity = new User();
			if(i==1){
				entity.setEmail("teacher_"+i+"@163.com");
				entity.setRealname("教师"+i);
				entity.setUsername("teacher_"+i);
			}else{
				entity.setEmail("student_"+i+"@163.com");
				entity.setRealname("学生"+i);
				entity.setUsername("student_"+i);
			}
			entity.setPassword("21218cca77804d2ba1922c33e0151105");//888888
			entity.setState(State.Enable.getValue());
			lst.add(entity);
		}
		userDao.save(lst);
	}
	
	@Test
	public void testInsertStudentTeacher() {
		// TODO 初始化31个用户，30个学生，1个教师
		List<User> usrs = userDao.findAll();
		
		List<Student> stus = new ArrayList<Student>();
		List<Teacher> tecs = new ArrayList<Teacher>();
		for(int i=0; i<usrs.size(); i++){
			User usr = usrs.get(i);
			String rn = usr.getUsername();
			if(rn.startsWith("student_")){
				Student stu = new Student();
				stu.setId(usr.getId());
				stu.setStuNo(RandomUtil.getRandomString(11, "i"));//11位学号
				stu.setTelephone("135"+RandomUtil.getRandomString(8, "i"));
				stu.setName(usr.getRealname());
				stu.setSex(i%2==0?1:0);
				stu.setBirthday(new Date());
				stu.setCity(i%2==0?"上海":"北京");
				stu.setPhoto("/test"+i+".jpg");
				stus.add(stu);
			}else if(rn.startsWith("teacher_")){
				Teacher tec = new Teacher();
				tec.setId(usr.getId());
				tec.setName(usr.getRealname());
				tec.setTecPosition(i%2==0?"教师":"副教授");
				tec.setSchool(i%2==0?"上海交通大学":"北京大学");
				tec.setCity(i%2==0?"上海":"北京");
				tec.setSex(i%2==0?1:0);
				tec.setBirthday(new Date());
				tec.setPhoto("/test"+i+".jpg");
				tec.setIntroduction(i%2==0?"上海交通大学。。。":"北京大学。。。");
				tecs.add(tec);
			}
		}
		studentDao.save(stus);
		teacherDao.save(tecs);
	}
	
	@Test
	public void testInsertBook(){
		// TODO 初始化100本图书
		List<Book> boks = new ArrayList<Book>();
		for(int i=1; i<=100; i++){
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
			boks.add(bok);
		}
		
		int before = countRowsInTable("tb_book");
		bookDao.save(boks);
		int after = countRowsInTable("tb_book");
		
		assertEquals(before + 100, after);
	}
	
	@Test
	public void testInsertChapter(){
		// TODO 初始化1000个章节，每本书10个章节
		List<Book> boks = bookDao.findAll();
		
		List<Chapter> chps = new ArrayList<Chapter>();
		for(int i=0; i<boks.size(); i++){
			Book bok = boks.get(i);
			for(int j=1; j<=10; j++){
				Chapter chp = new Chapter();
				chp.setName("第"+RandomUtil.getRandomString(5, "u")+"章标题");
				chp.setChpOrder(j);
				chp.setBook(bok);
				chps.add(chp);
			}
		}
		
		int before = countRowsInTable("tb_chapter");
		chapterDao.save(chps);
		int after = countRowsInTable("tb_chapter");
		assertEquals(before + 1000, after);
	}
	
	@Test
	public void testInsertCourse(){
		// TODO 初始化100个班级，每个班级有1本图书
		List<Course> cors = new ArrayList<Course>();
		
		List<Book> boks = bookDao.findAll();
		List<Teacher> tecs = teacherDao.findAll();
		Date now = new Date();
		for(int i=0; i<100; i++){
			Course cor = new Course();
			cor.setName(RandomUtil.getRandomString(3, "u")+"_班");
			cor.setBokKind(i%2);
			cor.setBokType(i%2);
			cor.setStartDate(DateUtils.addYears(now, -1));
			if(i%2==0){
				cor.setEndDate(DateUtils.addDays(now, -15));
			}else{
				cor.setEndDate(DateUtils.addDays(now, 15));
			}
			cor.setTeacher(tecs.get(0));
			cor.setBook(boks.get(i));
			cors.add(cor);
		}
		int before = countRowsInTable("tb_course");
		courseDao.save(cors);
		int after = countRowsInTable("tb_course");
		assertEquals(before + 100, after);
	}
	
	@Test
	public void testInsertCwr(){
		// TODO 插入1000个课件，每个班级10个，一个班级有10个章节，每个章节1个课件
		List<Courseware> cwrs = new ArrayList<Courseware>();
		
		List<Chapter> chps = chapterDao.findAll();
		for(int j=0; j<chps.size(); j++){
			Courseware cwr = new Courseware();
			cwr.setName(j+"_课件");
			cwr.setPptType(j%2);
			cwr.setPptPath("/ppt/"+j+".ppt");
			cwr.setViewNum(0);
			cwr.setDownNum(0);
			cwr.setPptStatus(0);
			cwr.setChapter(chps.get(j));
			cwrs.add(cwr);
		}
		
		int before = countRowsInTable("tb_courseware");
		coursewareDao.save(cwrs);
		int after = countRowsInTable("tb_courseware");
		assertEquals(before + 1000, after);
	}
	
	@Test
	public void testInsertAms(){
		// TODO 插入2000个作业，每个班级20个，一个班级有10个章节，每个章节2个作业
		List<Assignment> asms = new ArrayList<Assignment>();
		
		List<Chapter> chps = chapterDao.findAll();
		Date now = new Date();
		for(int j=0; j<chps.size(); j++){
			for(int k=0; k<2; k++){
				Assignment asm = new Assignment();
				asm.setName("作业_"+j+"_"+k);
				asm.setAssType(j%2);
				asm.setAssStatus(k);
				asm.setStartDate(now);
				asm.setEndDate(DateUtils.addDays(now, 15));
				asm.setAssPath("/ass/ams_"+j+"_"+k+".xml");
				asm.setChapter(chps.get(j));
				asms.add(asm);
			}
		}
		int before = countRowsInTable("tb_assignment");
		assignmentDao.save(asms);
		int after = countRowsInTable("tb_assignment");
		assertEquals(before + 2000, after);
	}
	
	
	@Test
	public void testInsertStuCor(){
		// TODO 每个学生有30个班级，暂时还没区分已修、正修，有待进一步改进
		List<Student> stus = studentDao.findAll();
		List<Course> cors = courseDao.findAll();
		
		for(int i=0; i<stus.size(); i++){
			Student stu = stus.get(i);
			List<Course> cors2 = new ArrayList<Course>();
//			for(int j=0; j<30; j++){
				cors2.add(cors.get(0));
//			}
			stu.setCourses(cors2);
		}
		studentDao.save(stus);
	}
	
	@Test
	public void testInsertCorCwr(){
		// TODO 每个班级10个课件
		List<Course> cors2 = new ArrayList<Course>();
		
		List<Course> cors = courseDao.findAll();
		for(Course cor:cors){
			List<Courseware> cwrs = coursewareDao.findAllbyBokId(cor.getBook().getId());
			cor.setCoursewares(cwrs);
			cors2.add(cor);
		}
		courseDao.save(cors2);
	}
	
	@Test
	public void testInsertCorAms(){
		// TODO 每个班级20个作业
		List<Course> cors2 = new ArrayList<Course>();
		
		List<Course> cors = courseDao.findAll();
		for(Course cor:cors){
			List<Assignment> asms = assignmentDao.findAllbyBokId(cor.getBook().getId());
			cor.setAssignments(asms);
			cors2.add(cor);
		}
		courseDao.save(cors2);
	}
	
	@Test
	public void testInsertStuAms(){
		List<Myassign> mass = new ArrayList<Myassign>();
		
		List<Student> stus = studentDao.findAll();
		Assignment asm = new Assignment();
		asm.setId("402880e53d966127013d96613add0000");
		for(int i=0; i<stus.size(); i++){
			Student stu = stus.get(i);
			Myassign mas = new Myassign();
			mas.setMyassPath("/myassign/mas_"+i+"_.xml");
			mas.setStudent(stu);
			mas.setAssignment(asm);
			mas.setAssScore(90);
			mass.add(mas);
		}
		myassignDao.save(mass);
	}
	
	@Test
	public void testSelectCwrByBokId(){
		List<Courseware> cwrs = coursewareDao.findAllbyBokId("402880e53d95fb0f013d95fb1f69001e");
		assertEquals(cwrs.size(), 10);
	}
	
	@Test
	public void testSelectAmsByBokId(){
		List<Assignment> asms = assignmentDao.findAllbyBokId("402880e53d95fb0f013d95fb1f69001e");
		assertEquals(asms.size(), 20);
	}
	
	//-----------教师-----------
	@Test
	public void testSelectCurrCourse(){
		CorTec cor = courseDao.getCurrCourse("402880e53d95ff85013d95ff950e0000");
		assertEquals(cor.getId(),"402880e53d95ff85013d95ff950e0000");
	}
	
	@Test
	public void testSelectCurrCorStus(){
		Pageable request = new PageRequest(1,10);
		Page<Student> page =  courseDao.getCurrCorStus("402880e53d95ff85013d95ff950e0000", request);
		assertEquals(page.getTotalElements(), 30);
		assertEquals(page.getTotalPages(), 3);
	}
	
	@Test
	public void testSelectCurrCorCwrs(){
		Pageable request = new PageRequest(1,10);
		Page<CorCwr> page =  courseDao.getCurrCorCwrs("402880e53d95ff85013d95ff950e0000", request);
		assertEquals(page.getTotalElements(), 10);
		assertEquals(page.getTotalPages(), 1);
	}
	
	@Test
	public void testSelectCurrCorAsms(){
		Pageable request = new PageRequest(1,10);
		Page<CorAsm> page = courseDao.getCurrCorAsms("402880e53d95ff85013d95ff950e0000", request);
		assertEquals(page.getTotalElements(), 20);
		assertEquals(page.getTotalPages(), 2);
	}
	
	@Test
	public void testSelectCurrStuAsms(){
		Pageable request = new PageRequest(1,10);
		Page<StuAsm> page = assignmentDao.getCurrStuAsms("402880e53d966127013d96613add0000", request);
		assertEquals(page.getTotalElements(), 30);
		assertEquals(page.getTotalPages(), 3);
	}
	
}
