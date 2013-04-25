package com.yinzhi.eduplat.entity.reading;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yinzhi.eduplat.entity.UniversallyUniqueIdentifier;

/**
 * 收藏类
 * @author 黄清泉
 * @date 2013-4-6
 */
@Entity
@Table(name = "tb_favorite")
@SuppressWarnings("serial")
public class Favorite extends UniversallyUniqueIdentifier {

	private String fkBookId;
	private String fkUserId;
	private Date createTime;

	@Column(name="fk_book_id", length=32)
	public String getFkBookId() {
		return fkBookId;
	}

	public void setFkBookId(String fkBookId) {
		this.fkBookId = fkBookId;
	}

	@Column(name="fk_user_id", length=32)
	public String getFkUserId() {
		return fkUserId;
	}

	public void setFkUserId(String fkUserId) {
		this.fkUserId = fkUserId;
	}

	@Column(name = "create_time")
	@Temporal(TemporalType.DATE)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
