package com.yinzhi.eduplat.entity.finance;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.yinzhi.eduplat.entity.UniversallyUniqueIdentifier;


/**
 * 章节类
 * @author 黄清泉
 * @date 2013-3-12
 */
@Entity
@Table(name="tb_chapter")
@SuppressWarnings("serial")
public class Chapter extends UniversallyUniqueIdentifier{

    // Fields    

	 private String name;
     private Integer chpOrder;
     private Book book;
     private List<Courseware> coursewares;
     private List<Assignment> assignments;

    // Constructors

    /** default constructor */
    public Chapter() {
    }
    
    public Chapter(String id){
    	this.id = id;
    }
    
    public Chapter(String id, String name){
    	this.id = id;
    	this.name = name;
    }

    @Column(name="name", nullable=false, length=64)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="chp_order", nullable=false)

    public Integer getChpOrder() {
        return this.chpOrder;
    }
    
    public void setChpOrder(Integer chpOrder) {
        this.chpOrder = chpOrder;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_book_id")
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="chapter")
	public List<Courseware> getCoursewares() {
		return coursewares;
	}

	public void setCoursewares(List<Courseware> coursewares) {
		this.coursewares = coursewares;
	}

	@OneToMany(cascade=CascadeType.ALL, mappedBy="chapter")
	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

}