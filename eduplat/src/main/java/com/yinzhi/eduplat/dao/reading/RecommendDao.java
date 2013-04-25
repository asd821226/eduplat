package com.yinzhi.eduplat.dao.reading;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yinzhi.eduplat.entity.reading.Recommend;

/**
 * 推荐数据访问
 * @author 黄清泉
 * @date 2013-4-6
 */
public interface RecommendDao extends JpaRepository<Recommend, String>,JpaSpecificationExecutor<Recommend>{

}
