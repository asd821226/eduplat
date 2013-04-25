package com.yinzhi.eduplat.dao.finance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.yinzhi.eduplat.entity.finance.Courseware;

/**
 * 课件数据访问
 * @author 黄清泉
 * @date 2013-3-13
 */
public interface CoursewareDao extends JpaRepository<Courseware, String>,JpaSpecificationExecutor<Courseware>{

	@Query("select wl from Book b left join b.chapters cl left join cl.coursewares wl where b.id=?1")
	public List<Courseware> findAllbyBokId(String bokId);
	
	
	@Modifying
	@Query("update Courseware c set c.pptStatus = ?1 where c.id = ?2")
	public int updateStatus(int status, String cwrId);
	
}
