package com.yinzhi.eduplat.dao.finance;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.yinzhi.eduplat.entity.finance.CorAsm;
import com.yinzhi.eduplat.entity.finance.CorCwr;
import com.yinzhi.eduplat.entity.finance.CorTec;
import com.yinzhi.eduplat.entity.finance.Course;
import com.yinzhi.eduplat.entity.finance.Student;

/**
 * 课程数据访问
 * @author 黄清泉
 * @date 2013-3-13
 */
public interface CourseDao extends JpaRepository<Course, String>,JpaSpecificationExecutor<Course>{
	
	/**
	 * 获取教师所有正教班级，分页显示
	 * @param usrId
	 * @param pageable
	 * @return
	 */
	@Query("select c from Course c left join c.teacher t where t.id=?1 and c.endDate > now() and c.corStatus<>3 order by c.endDate desc")
	public Page<Course> getTeacherCorings(String usrId, Pageable pageable);
	
	/**
	 * 获取教师所有已教班级，分页显示
	 * @param usrId
	 * @param pageable
	 * @return
	 */
	@Query("select c from Course c left join c.teacher t where t.id=?1 and c.endDate < now() and c.corStatus<>3 order by c.endDate desc")
	public Page<Course> getTeacherCoreds(String usrId, Pageable pageable);
	
	/**
	 * 获取学生所有在修课程，分页显示
	 * @param usrId
	 * @param pageable
	 * @return
	 */
	@Query("select cl from Student s left join s.courses cl where s.id=?1 and cl.endDate > now() and cl.corStatus=2 order by cl.endDate desc")
	public Page<Course> getStudentCorings(String usrId, Pageable pageable);
	
	/**
	 * 获取学生所有已修课程，分页显示
	 * @param usrId
	 * @param pageable
	 * @return
	 */
	@Query("select cl from Student s left join s.courses cl where s.id=?1 and cl.endDate < now() and cl.corStatus=2 order by cl.endDate desc")
	public Page<Course> getStudentCoreds(String usrId, Pageable pageable);
	
	
	/**
	 * 获取当前班级所有学生列表
	 * @param id 班级ID
	 * @param pageable
	 * @return
	 */
	@Query("select sl from Course c left join c.students sl where c.id=?1")
	public Page<Student> getCurrCorStus(String id, Pageable pageable);
	
	/**
	 * 获取当前班级基本信息、教师信息、学生总数
	 * @param id
	 * @return
	 */
	@Query("select new com.yinzhi.eduplat.entity.finance.CorTec(c.id,c.name,b.picPath,t.name,t.school,c.startDate,c.endDate,COUNT(c)) from Course c left join c.teacher t left join c.students sl left join c.book b where c.id=?1")
	public CorTec getCurrCourse(String id);
	
	@Query("select COUNT(c) from Course c left join c.students sl where c.id=?1")
	public long getCurrCorStuNum(String id);
	
	/**
	 * 获取本班的课件，分页
	 * @param id
	 * @param pageable
	 * @return
	 */
	@Query("select new com.yinzhi.eduplat.entity.finance.CorCwr(c.id,wl.id,p.id,p.chpOrder,wl.name,p.name) from Course c left join c.coursewares wl left join wl.chapter p where c.id=?1")
	public Page<CorCwr> getCurrCorCwrs(String id, Pageable pageable);
	
	/**
	 * 获取本班已发布的课件，分页
	 * @param id
	 * @param cwrStatus
	 * @param pageable
	 * @return
	 */
	@Query("select new com.yinzhi.eduplat.entity.finance.CorCwr(c.id,wl.id,p.id,p.chpOrder,wl.name,p.name) from Course c left join c.coursewares wl left join wl.chapter p where wl.pptStatus=?2 and c.id=?1")
	public Page<CorCwr> getCurrCorCwrs(String id, int cwrStatus, Pageable pageable);
	
	/**
	 * 获取本班的作业，分页
	 * @param id
	 * @param pageable
	 * @return
	 */
	@Query("select new com.yinzhi.eduplat.entity.finance.CorAsm(c.id,al.id,p.chpOrder,p.name,al.name,al.assType,al.startDate,al.endDate,al.assStatus) from Course c left join c.assignments al left join al.chapter p where c.id=?1 order by al.endDate desc")
	public Page<CorAsm> getCurrCorAsms(String id, Pageable pageable);
	
	/**
	 * 获取本班已发布的作业，分页
	 * @param id
	 * @param asmStatus
	 * @return
	 */
	@Query("select new com.yinzhi.eduplat.entity.finance.CorAsm(c.id,al.id,p.chpOrder,p.name,al.name,al.assType,al.startDate,al.endDate,al.assStatus) from Course c left join c.assignments al left join al.chapter p where al.assStatus=?2 and c.id=?1 order by al.endDate desc")
	public Page<CorAsm> getCurrCorAsms(String id, int asmStatus, Pageable pageable);
	
	/**
	 * 获取可共享的班级
	 * @param bokId
	 * @param tecId
	 * @param corId
	 * @return
	 */
	@Query("select c from Course c left join c.teacher t left join c.book b where b.id=?1 and t.id=?2 and c.id<>?3")
	public List<Course> getShareCors(String bokId, String tecId, String corId);
	
}
