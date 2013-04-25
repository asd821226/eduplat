package com.yinzhi.eduplat.dao.finance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yinzhi.eduplat.entity.finance.Teacher;

/**
 * 教师数据访问
 * @author 黄清泉
 * @date 2013-3-13
 */
public interface TeacherDao extends JpaRepository<Teacher, String>,JpaSpecificationExecutor<Teacher>{

}
