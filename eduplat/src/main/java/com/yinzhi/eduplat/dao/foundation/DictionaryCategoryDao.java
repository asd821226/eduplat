package com.yinzhi.eduplat.dao.foundation;

import com.yinzhi.eduplat.entity.foundation.DictionaryCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 字典类别数据访问
 * 
 * @author vincent
 *
 */
public interface DictionaryCategoryDao extends JpaRepository<DictionaryCategory, String>, JpaSpecificationExecutor<DictionaryCategory>{

}
