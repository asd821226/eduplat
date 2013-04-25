package com.yinzhi.eduplat.entity.reading;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yinzhi.eduplat.entity.UniversallyUniqueIdentifier;

/**
 * 笔记类
 * @author 黄清泉
 * @date 2013-4-6
 */
@Entity
@Table(name = "tb_boknote")
@SuppressWarnings("serial")
public class Boknote extends UniversallyUniqueIdentifier {

	private Integer pageNo;
	private String chpName;
	private String content;
	private Integer nteStatus;
	private String fkBookId;
	private String fkUserId;
	private Date createTime;

	@Column(name="page_no", length=6)
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	@Column(name="chp_name", length=64)
	public String getChpName() {
		return chpName;
	}

	public void setChpName(String chpName) {
		this.chpName = chpName;
	}

	@Column(name="content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name="nte_status", length=3)
	public Integer getNteStatus() {
		return nteStatus;
	}

	public void setNteStatus(Integer nteStatus) {
		this.nteStatus = nteStatus;
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
