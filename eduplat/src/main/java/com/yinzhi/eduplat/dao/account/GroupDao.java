package com.yinzhi.eduplat.dao.account;

import java.util.List;

import com.yinzhi.eduplat.entity.account.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 部门数据访问
 * @author 黄清泉
 * @date 2013-3-17
 */
public interface GroupDao extends JpaRepository<Group, String>,JpaSpecificationExecutor<Group>{

	/**
	 * 通过用户id获取所有资源
	 * 
	 * @param userId 用户id
	 * 
	 * @return List
	 */
	@Query("select gl from User u left join u.groupsList gl  where u.id=?1 and gl.type= '03'")
	List<Group> findUserGroups(String userId);

}
