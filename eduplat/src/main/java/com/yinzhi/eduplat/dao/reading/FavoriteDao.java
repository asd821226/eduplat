package com.yinzhi.eduplat.dao.reading;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yinzhi.eduplat.entity.reading.Favorite;

/**
 * 收藏数据访问
 * @author 黄清泉
 * @date 2013-4-6
 */
public interface FavoriteDao extends JpaRepository<Favorite, String>,JpaSpecificationExecutor<Favorite>{

}
