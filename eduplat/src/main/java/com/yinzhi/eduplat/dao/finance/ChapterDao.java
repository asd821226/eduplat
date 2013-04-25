package com.yinzhi.eduplat.dao.finance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.yinzhi.eduplat.entity.finance.Chapter;

/**
 * 章节数据访问
 * @author 黄清泉
 * @date 2013-3-13
 */
public interface ChapterDao extends JpaRepository<Chapter, String>,JpaSpecificationExecutor<Chapter>{

	@Query("select new com.yinzhi.eduplat.entity.finance.Chapter(cl.id,cl.name) from Book b left join b.chapters cl where b.id=?1 order by cl.chpOrder asc")
	public List<Chapter> findChpsbyBokId(String bokId);
	
}
