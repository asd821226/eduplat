package com.yinzhi.eduplat.entity.finance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.yinzhi.eduplat.entity.UniversallyUniqueIdentifier;


/**
 * 学生卷子表
 * @author 黄清泉
 * @date 2013-4-3
 */
@Entity
@Table(name="tb_testpaper")
@SuppressWarnings("serial")
public class Testpaper extends UniversallyUniqueIdentifier{

	private Integer queKind;
	private String content;
	private String answer;
	private Integer queScore;
	private Integer qusType;
	private Myassign myassign;
	private String fkQueId;
	
	@Column(name="que_kind", length=3)
	public Integer getQueKind() {
		return queKind;
	}
	public void setQueKind(Integer queKind) {
		this.queKind = queKind;
	}
	
	@Column(name="content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name="answer")
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@Column(name="que_score")
	public Integer getQueScore() {
		return queScore;
	}
	public void setQueScore(Integer queScore) {
		this.queScore = queScore;
	}
	
	@Column(name="qus_type", length = 3)
	public Integer getQusType() {
		return qusType;
	}
	public void setQusType(Integer qusType) {
		this.qusType = qusType;
	}
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "fk_ass_id", nullable = false, updatable = false)
	public Myassign getMyassign() {
		return myassign;
	}
	public void setMyassign(Myassign myassign) {
		this.myassign = myassign;
	}
	
	@Column(name="fk_que_id")
	public String getFkQueId() {
		return fkQueId;
	}
	public void setFkQueId(String fkQueId) {
		this.fkQueId = fkQueId;
	}
	
}
