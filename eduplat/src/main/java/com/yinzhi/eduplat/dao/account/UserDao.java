package com.yinzhi.eduplat.dao.account;

import com.yinzhi.eduplat.entity.account.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 用户数据访问
 * @author 黄清泉
 * @date 2013-3-12
 */
public interface UserDao extends JpaRepository<User, String>,JpaSpecificationExecutor<User>{

	/**
	 * 通过用户id更新用户密码
	 * 
	 * @param userId 用户id
	 * @param password 密码
	 */
	@Modifying
	@Query("update User u set u.password = ?1 where u.id = ?2")
	public int updatePassword(String password,String userId);

	
}
