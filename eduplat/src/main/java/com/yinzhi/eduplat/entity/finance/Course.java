package com.yinzhi.eduplat.entity.finance;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yinzhi.eduplat.entity.UniversallyUniqueIdentifier;


/**
 * 课程/班级类
 * @author 黄清泉
 * @date 2013-3-12
 */
@Entity
@Table(name="tb_course")
@SuppressWarnings("serial")
public class Course extends UniversallyUniqueIdentifier{

    // Fields    
     private String name;
     private Integer bokKind;
     private Integer bokType;
     private Date startDate;
     private Date endDate;
     private Integer corStatus;
     private Teacher teacher;
     private Book book;
     private List<Student> students;
     private List<Assignment> assignments;
     private List<Courseware> coursewares;
     private String bokPic;
     private Integer stuSize;
     private Integer assSize;
     private Integer cwrSize;

    // Constructors

    public Course() {
    }

	public Course(String id){
    	this.id = id;
    }
    
    @Column(name="name", nullable=false, length=64)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="bok_kind", nullable=false)

    public Integer getBokKind() {
        return this.bokKind;
    }
    
    public void setBokKind(Integer bokKind) {
        this.bokKind = bokKind;
    }
    
    @Column(name="bok_type", nullable=false)
    public Integer getBokType() {
        return this.bokType;
    }
    
    public void setBokType(Integer bokType) {
        this.bokType = bokType;
    }
    
    @Column(name="start_date")
    @Temporal(TemporalType.DATE)
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    @Column(name="end_date")
    @Temporal(TemporalType.DATE)
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    @Column(name="cor_status")
    public Integer getCorStatus() {
		return corStatus;
	}

	public void setCorStatus(Integer corStatus) {
		this.corStatus = corStatus;
	}

	@ManyToOne 
    @JoinColumn(name="fk_teacher_id", nullable=false)
    public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_book_id")
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@ManyToMany(mappedBy="courses")
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "tb_course_assignment", joinColumns = { @JoinColumn(name = "fk_course_id") }, inverseJoinColumns = { @JoinColumn(name = "fk_assignment_id") })
	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "tb_course_courseware", joinColumns = { @JoinColumn(name = "fk_course_id") }, inverseJoinColumns = { @JoinColumn(name = "fk_courseware_id") })
	public List<Courseware> getCoursewares() {
		return coursewares;
	}

	public void setCoursewares(List<Courseware> coursewares) {
		this.coursewares = coursewares;
	}

	@Column(name="bok_pic", length=256)
	public String getBokPic() {
		return bokPic;
	}

	public void setBokPic(String bokPic) {
		this.bokPic = bokPic;
	}

	@Column(name="stu_size")
	public Integer getStuSize() {
		return stuSize;
	}

	public void setStuSize(Integer stuSize) {
		this.stuSize = stuSize;
	}

	@Column(name="ass_size")
	public Integer getAssSize() {
		return assSize;
	}

	public void setAssSize(Integer assSize) {
		this.assSize = assSize;
	}

	@Column(name="cwr_size")
	public Integer getCwrSize() {
		return cwrSize;
	}

	public void setCwrSize(Integer cwrSize) {
		this.cwrSize = cwrSize;
	}

}