package com.yinzhi.eduplat.entity.finance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.yinzhi.eduplat.entity.UniversallyUniqueIdentifier;

/**
 * 作业的题型类
 * 
 * @author 黄清泉
 * @date 2013-3-12
 */
@Entity
@Table(name = "tb_assignqus")
@SuppressWarnings("serial")
public class Assignqus extends UniversallyUniqueIdentifier {

	private Assignment assignment;
	private Integer qusType;
	private Integer queNum;
	private Integer queScore;
	private Integer queOrder;
	private Integer queKind;
	private String queInfo;//id1, id2, id3, ..., idN

	public Assignqus() {
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "fk_asm_id", nullable = false, updatable = false)
	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	@Column(name = "qus_type", length = 3)
	public Integer getQusType() {
		return qusType;
	}

	public void setQusType(Integer qusType) {
		this.qusType = qusType;
	}

	@Column(name = "que_num")
	public Integer getQueNum() {
		return queNum;
	}

	public void setQueNum(Integer queNum) {
		this.queNum = queNum;
	}

	@Column(name = "que_score")
	public Integer getQueScore() {
		return queScore;
	}

	public void setQueScore(Integer queScore) {
		this.queScore = queScore;
	}

	@Column(name = "que_order")
	public Integer getQueOrder() {
		return queOrder;
	}

	public void setQueOrder(Integer queOrder) {
		this.queOrder = queOrder;
	}

	@Column(name = "que_kind")
	public Integer getQueKind() {
		return queKind;
	}

	public void setQueKind(Integer queKind) {
		this.queKind = queKind;
	}

	@Column(name = "que_info", length = 512)
	public String getQueInfo() {
		return queInfo;
	}

	public void setQueInfo(String queInfo) {
		this.queInfo = queInfo;
	}

}