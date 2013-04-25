package com.yinzhi.eduplat.entity.reading;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yinzhi.eduplat.entity.UniversallyUniqueIdentifier;

/**
 * 标签类
 * @author 黄清泉
 * @date 2013-4-6
 */
@Entity
@Table(name = "tb_bokcate")
@SuppressWarnings("serial")
public class Bokcate extends UniversallyUniqueIdentifier {

	private String name;
	private String fkCateId;
	private String fkBookId;

	@Column(name="name", length=64)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="fk_cate_id", length=32)
	public String getFkCateId() {
		return fkCateId;
	}

	public void setFkCateId(String fkCateId) {
		this.fkCateId = fkCateId;
	}

	@Column(name="fk_book_id", length=32)
	public String getFkBookId() {
		return fkBookId;
	}

	public void setFkBookId(String fkBookId) {
		this.fkBookId = fkBookId;
	}

}
