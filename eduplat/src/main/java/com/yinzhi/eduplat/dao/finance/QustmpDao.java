package com.yinzhi.eduplat.dao.finance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yinzhi.eduplat.entity.finance.Qustmp;

/**
 * 题库，按模板出题方式数据访问
 * @author 黄清泉
 * @date 2013-4-3
 */
public interface QustmpDao extends JpaRepository<Qustmp, String>,JpaSpecificationExecutor<Qustmp>{

}
