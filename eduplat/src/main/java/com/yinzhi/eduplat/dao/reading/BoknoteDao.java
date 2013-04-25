package com.yinzhi.eduplat.dao.reading;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yinzhi.eduplat.entity.reading.Boknote;

/**
 * 笔记数据访问
 * @author 黄清泉
 * @date 2013-4-6
 */
public interface BoknoteDao extends JpaRepository<Boknote, String>,JpaSpecificationExecutor<Boknote>{

}
