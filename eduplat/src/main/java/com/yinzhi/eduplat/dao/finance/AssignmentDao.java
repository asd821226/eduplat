package com.yinzhi.eduplat.dao.finance;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.yinzhi.eduplat.entity.finance.Assignment;
import com.yinzhi.eduplat.entity.finance.StuAsm;

/**
 * 作业数据访问
 * @author 黄清泉
 * @date 2013-3-13
 */
public interface AssignmentDao extends JpaRepository<Assignment, String>,JpaSpecificationExecutor<Assignment>{

	@Query("select al from Book b left join b.chapters cl left join cl.assignments al where b.id=?1")
	public List<Assignment> findAllbyBokId(String bokId);
	

	@Query("select new com.yinzhi.eduplat.entity.finance.StuAsm(s.id,ml.id,s.stuNo,s.name,ml.assScore) from Assignment a left join a.myassigns ml left join ml.student s where a.id=?1")
	public Page<StuAsm> getCurrStuAsms(String id, Pageable pageable);
	
	
	@Modifying
	@Query("update Assignment a set a.assStatus = ?1 where a.id = ?2")
	public int updateStatus(int status, String asmId);
	
}
