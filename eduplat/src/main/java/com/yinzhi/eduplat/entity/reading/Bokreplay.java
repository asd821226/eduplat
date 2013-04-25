package com.yinzhi.eduplat.entity.reading;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yinzhi.eduplat.entity.UniversallyUniqueIdentifier;

/**
 * 回应类
 * @author 黄清泉
 * @date 2013-4-6
 */
@Entity
@Table(name = "tb_bokreplay")
@SuppressWarnings("serial")
public class Bokreplay extends UniversallyUniqueIdentifier {

	private String content;
	private Integer repStatus;
	private String fkCommentId;
	private String fkUserId;
	private Date createTime;

	@Column(name="content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name="rep_status", length=3)
	public Integer getRepStatus() {
		return repStatus;
	}

	public void setRepStatus(Integer repStatus) {
		this.repStatus = repStatus;
	}

	@Column(name="fk_comment_id", length=32)
	public String getFkCommentId() {
		return fkCommentId;
	}

	public void setFkCommentId(String fkCommentId) {
		this.fkCommentId = fkCommentId;
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
