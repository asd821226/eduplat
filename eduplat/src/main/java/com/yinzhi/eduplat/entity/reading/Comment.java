package com.yinzhi.eduplat.entity.reading;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yinzhi.eduplat.entity.UniversallyUniqueIdentifier;

/**
 * 书评类
 * @author 黄清泉
 * @date 2013-4-6
 */
@Entity
@Table(name = "tb_comment")
@SuppressWarnings("serial")
public class Comment extends UniversallyUniqueIdentifier {

	private String title;
	private String content;
	private Integer cmtStatus;
	private String fkBookId;
	private String fkUserId;
	private Date createTime;

	@Column(name="title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name="cmt_status", length=3)
	public Integer getCmtStatus() {
		return cmtStatus;
	}

	public void setCmtStatus(Integer cmtStatus) {
		this.cmtStatus = cmtStatus;
	}

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
