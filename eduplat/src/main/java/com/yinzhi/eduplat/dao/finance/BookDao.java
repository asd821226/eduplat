package com.yinzhi.eduplat.dao.finance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.yinzhi.eduplat.entity.finance.Book;

/**
 * 图书数据访问
 * @author 黄清泉
 * @date 2013-3-13
 */
public interface BookDao extends JpaRepository<Book, String>,JpaSpecificationExecutor<Book>{

	@Query("select b from Book b order by b.createTime desc")
	public Page<Book> getNewboks(Pageable pageable);
	
	@Query("select b from Book b where b.name like CONCAT(?1, '%') or b.isbn = ?1 or b.author = ?1 order by b.createTime desc")
	public Page<Book> search(String keyword, Pageable pageable);
}
