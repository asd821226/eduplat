package com.yinzhi.eduplat.dao.finance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.yinzhi.eduplat.entity.finance.Testpaper;

/**
 * 学生卷子数据访问
 * @author 黄清泉
 * @date 2013-4-3
 */
public interface TestpaperDao extends JpaRepository<Testpaper, String>,JpaSpecificationExecutor<Testpaper>{

	@Query("select t from Testpaper t left join t.myassign tm where tm.id=?1")
	public List<Testpaper> getTestpapersByAssId(String assId);
	
}
