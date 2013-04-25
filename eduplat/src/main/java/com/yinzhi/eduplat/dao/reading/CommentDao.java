package com.yinzhi.eduplat.dao.reading;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yinzhi.eduplat.entity.reading.Comment;

/**
 * 书评数据访问
 * @author 黄清泉
 * @date 2013-4-6
 */
public interface CommentDao extends JpaRepository<Comment, String>,JpaSpecificationExecutor<Comment>{

}
