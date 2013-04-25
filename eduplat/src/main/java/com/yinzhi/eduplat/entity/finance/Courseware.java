package com.yinzhi.eduplat.entity.finance;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.yinzhi.eduplat.entity.UniversallyUniqueIdentifier;


/**
 * 课件类
 * @author 黄清泉
 * @date 2013-3-12
 */
@Entity
@Table(name="tb_courseware")
@SuppressWarnings("serial")
public class Courseware extends UniversallyUniqueIdentifier{

    // Fields    
     private String name;
     private Integer pptType;
     private String pptPath;
     private Integer viewNum;
     private Integer downNum;
     private Integer pptStatus;
     private Chapter chapter;
     private List<Course> courses;

    // Constructors

    /** default constructor */
    public Courseware() {
    }

    @Column(name="name", length=64)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="ppt_type", nullable=false)

    public Integer getPptType() {
        return this.pptType;
    }
    
    public void setPptType(Integer pptType) {
        this.pptType = pptType;
    }
    
    @Column(name="ppt_path", nullable=false, length=256)

    public String getPptPath() {
        return this.pptPath;
    }
    
    public void setPptPath(String pptPath) {
        this.pptPath = pptPath;
    }
    
    @Column(name="view_num", nullable=false)

    public Integer getViewNum() {
        return this.viewNum;
    }
    
    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }
    
    @Column(name="down_num", nullable=false)

    public Integer getDownNum() {
        return this.downNum;
    }
    
    public void setDownNum(Integer downNum) {
        this.downNum = downNum;
    }
    
    @Column(name="ppt_status", nullable=false)
    
    public Integer getPptStatus() {
		return pptStatus;
	}

	public void setPptStatus(Integer pptStatus) {
		this.pptStatus = pptStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_chapter_id")
	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "tb_course_courseware", joinColumns = { @JoinColumn(name = "fk_courseware_id") }, inverseJoinColumns = { @JoinColumn(name = "fk_course_id") })
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}