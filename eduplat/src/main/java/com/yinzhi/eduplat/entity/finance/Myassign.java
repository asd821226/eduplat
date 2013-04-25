package com.yinzhi.eduplat.entity.finance;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.yinzhi.eduplat.entity.UniversallyUniqueIdentifier;

/**
 * 学生的作业类
 * 
 * @author 黄清泉
 * @date 2013-3-12
 */
@Entity
@Table(name = "tb_myassign")
@SuppressWarnings("serial")
public class Myassign extends UniversallyUniqueIdentifier {

	private String myassPath;
	private Assignment assignment;
	private Student student;
	private Integer assScore;
	private Integer mssStatus;
	private List<Testpaper> testpapers;

	public Myassign() {
	}

	public Myassign(String id, Integer assScore) {
		this.id = id;
		this.assScore = assScore;
	}

	@Column(name = "myass_path", length = 256)
	public String getMyassPath() {
		return myassPath;
	}

	public void setMyassPath(String myassPath) {
		this.myassPath = myassPath;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "fk_asm_id", nullable = false, updatable = false)
	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "fk_stu_id", nullable = false, updatable = false)
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Column(name = "ass_score")
	public Integer getAssScore() {
		return assScore;
	}

	public void setAssScore(Integer assScore) {
		this.assScore = assScore;
	}

	@Column(name = "mss_status")
	public Integer getMssStatus() {
		return mssStatus;
	}

	public void setMssStatus(Integer mssStatus) {
		this.mssStatus = mssStatus;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "myassign")
	public List<Testpaper> getTestpapers() {
		return testpapers;
	}

	public void setTestpapers(List<Testpaper> testpapers) {
		this.testpapers = testpapers;
	}

}