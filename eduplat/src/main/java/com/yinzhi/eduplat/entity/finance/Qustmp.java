package com.yinzhi.eduplat.entity.finance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yinzhi.eduplat.entity.UniversallyUniqueIdentifier;


/**
 * 模板表
 * @author 黄清泉
 * @date 2013-4-3
 */
@Entity
@Table(name="tb_qustmp")
@SuppressWarnings("serial")
public class Qustmp extends UniversallyUniqueIdentifier{

	private String content;
	private Integer qusType;
	private String fkChpId;
	private String fkBokId;
	
	@Column(name="content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name="qus_type", length = 3)
	public Integer getQusType() {
		return qusType;
	}
	public void setQusType(Integer qusType) {
		this.qusType = qusType;
	}
	
	@Column(name="fk_chp_id")
	public String getFkChpId() {
		return fkChpId;
	}
	public void setFkChpId(String fkChpId) {
		this.fkChpId = fkChpId;
	}
	
	@Column(name="fk_bok_id")
	public String getFkBokId() {
		return fkBokId;
	}
	public void setFkBokId(String fkBokId) {
		this.fkBokId = fkBokId;
	}
	
	
}
