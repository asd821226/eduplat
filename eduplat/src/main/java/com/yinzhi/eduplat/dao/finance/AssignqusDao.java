package com.yinzhi.eduplat.dao.finance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yinzhi.eduplat.entity.finance.Assignqus;

/**
 * 作业的题型数据访问
 * @author 黄清泉
 * @date 2013-3-13
 */
public interface AssignqusDao extends JpaRepository<Assignqus, String>,JpaSpecificationExecutor<Assignqus>{

}
