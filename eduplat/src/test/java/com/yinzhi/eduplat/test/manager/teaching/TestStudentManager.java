package com.yinzhi.eduplat.test.manager.teaching;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yinzhi.eduplat.dao.finance.StudentDao;
import com.yinzhi.eduplat.entity.finance.Student;
import com.yinzhi.eduplat.test.manager.ManagerTestCaseSupport;

/**
 * 测试学生管理所有方法
 * @author 黄清泉
 * @date 2013-3-12
 */
public class TestStudentManager extends ManagerTestCaseSupport{

	@Autowired
	private StudentDao stuDao;


	@Test
	public void testInsertStudent() {
		
		Student entity = new Student();
		
		entity.setName("张三");
		entity.setSex(1);
		entity.setPhoto("/user/photo/123.jpg");
		entity.setCity("上海");
		entity.setBirthday(new Date());
		
		int before = countRowsInTable("tb_student");
		stuDao.save(entity);
		int after = countRowsInTable("tb_student");
		
		assertEquals(before + 1, after);
	}

	
}
