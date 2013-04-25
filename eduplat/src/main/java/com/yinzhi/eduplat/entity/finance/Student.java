package com.yinzhi.eduplat.entity.finance;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yinzhi.eduplat.entity.UniversallyUniqueIdentifier;


/**
 * 学生类
 * @author 黄清泉
 * @date 2013-3-12
 */
@Entity
@Table(name="tb_student")
@SuppressWarnings("serial")
public class Student extends UniversallyUniqueIdentifier{

	private String name;
	private String stuNo;
	private String telephone;
    private Integer sex;
    private String city;
    private String photo;
    private Date birthday;
    private List<Course> courses;

    /** default constructor */
    public Student() {
    }
    
    public Student(String id){
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
    
    @Column(name="stu_no", nullable=false, length=32)
    public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	@Column(name="telephone", nullable=false, length=32)
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name="sex", nullable=false)
    public Integer getSex() {
        return this.sex;
    }
    
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Column(name="city", nullable=false, length=128)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    @Column(name="photo", nullable=false, length=512)
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

    
    @ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "tb_student_course", joinColumns = { @JoinColumn(name = "fk_student_id") }, inverseJoinColumns = { @JoinColumn(name = "fk_course_id") })
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}