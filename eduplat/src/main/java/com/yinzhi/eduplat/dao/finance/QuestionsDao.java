package com.yinzhi.eduplat.dao.finance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yinzhi.eduplat.entity.finance.Questions;

/**
 * 题库，按随机出题方式数据访问
 * @author 黄清泉
 * @date 2013-4-3
 */
public interface QuestionsDao extends JpaRepository<Questions, String>,JpaSpecificationExecutor<Questions>{

	
}
