package com.yinzhi.eduplat.entity.finance;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yinzhi.eduplat.entity.UniversallyUniqueIdentifier;


/**
 * 教师类
 * @author 黄清泉
 * @date 2013-3-12
 */
@Entity
@Table(name="tb_teacher")
@SuppressWarnings("serial")
public class Teacher extends UniversallyUniqueIdentifier{


    // Fields    
	private String name;
    private String tecPosition;
    private String school;
    private String city;
    private Integer sex;
    private String photo;
    private Date birthday;
    private String introduction;
    private List<Course> courses;

    // Constructors
    public Teacher() {
    }
    
    public Teacher(String id) {
    	this.id = id;
    }
   
    // Property accessors

    @Column(name="name", nullable=false, length=64)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Column(name="tec_position", nullable=false, length=64)

    public String getTecPosition() {
        return this.tecPosition;
    }
    
    public void setTecPosition(String tecPosition) {
        this.tecPosition = tecPosition;
    }

    @Column(name="school", nullable=false, length=256)

    public String getSchool() {
        return this.school;
    }
    
    public void setSchool(String school) {
        this.school = school;
    }

    @Column(name="city", nullable=false, length=256)

    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    @Column(name="sex", nullable=false)

    public Integer getSex() {
        return this.sex;
    }
    
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Column(name="photo", nullable=false, length=256)

    public String getPhoto() {
        return this.photo;
    }
    
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Column(name="birthday")
    @Temporal(TemporalType.DATE)
    public Date getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Column(name="introduction", nullable=false, length=512)

    public String getIntroduction() {
        return this.introduction;
    }
    
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}