package com.yinzhi.eduplat.dao.finance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yinzhi.eduplat.entity.finance.Student;

/**
 * 学生数据访问
 * @author 黄清泉
 * @date 2013-3-12
 */
public interface StudentDao extends JpaRepository<Student, String>,JpaSpecificationExecutor<Student>{

	
}
