package com.yinzhi.eduplat.dao.finance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.yinzhi.eduplat.entity.finance.Myassign;

/**
 * 学生的作业数据访问
 * @author 黄清泉
 * @date 2013-3-13
 */
public interface MyassignDao extends JpaRepository<Myassign, String>,JpaSpecificationExecutor<Myassign>{

	@Query("select m from Myassign m left join m.student s left join m.assignment a where s.id=?2 and a.id=?1")
	public List<Myassign> getCurrAss(String asmId, String stuId);
	
}
