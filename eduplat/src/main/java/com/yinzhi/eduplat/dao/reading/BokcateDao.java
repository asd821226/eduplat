package com.yinzhi.eduplat.dao.reading;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yinzhi.eduplat.entity.reading.Bokcate;

/**
 * 标签数据访问
 * @author 黄清泉
 * @date 2013-3-13
 */
public interface BokcateDao extends JpaRepository<Bokcate, String>,JpaSpecificationExecutor<Bokcate>{

}
