package com.yinzhi.eduplat.entity.finance;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yinzhi.eduplat.entity.UniversallyUniqueIdentifier;

/**
 * 作业类
 * 
 * @author 黄清泉
 * @date 2013-3-12
 */
@Entity
@Table(name = "tb_assignment")
@SuppressWarnings("serial")
public class Assignment extends UniversallyUniqueIdentifier {

	private String name;
	private Integer assType;
	private String assPath;
	private Integer assStatus;
	private Date startDate;
	private Date endDate;
	private Chapter chapter;
	private List<Course> courses;
	private List<Myassign> myassigns;
	private List<Assignqus> assignquss;

	public Assignment() {
	}
	
	public Assignment(String id){
		this.id = id;
	}

	@Column(name = "name", length = 64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ass_type")
	public Integer getAssType() {
		return this.assType;
	}

	public void setAssType(Integer assType) {
		this.assType = assType;
	}

	@Column(name = "ass_status")
	public Integer getAssStatus() {
		return assStatus;
	}

	public void setAssStatus(Integer assStatus) {
		this.assStatus = assStatus;
	}

	@Column(name = "ass_path", length = 256)
	public String getAssPath() {
		return this.assPath;
	}

	public void setAssPath(String assPath) {
		this.assPath = assPath;
	}

	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_chapter_id")
	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tb_course_assignment", joinColumns = { @JoinColumn(name = "fk_assignment_id") }, inverseJoinColumns = { @JoinColumn(name = "fk_course_id") })
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "assignment")
	public List<Myassign> getMyassigns() {
		return myassigns;
	}

	public void setMyassigns(List<Myassign> myassigns) {
		this.myassigns = myassigns;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "assignment")
	public List<Assignqus> getAssignquss() {
		return assignquss;
	}

	public void setAssignquss(List<Assignqus> assignquss) {
		this.assignquss = assignquss;
	}

}