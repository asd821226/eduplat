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
 * 图书类
 * @author 黄清泉
 * @date 2013-3-12
 */
@Entity
@Table(name="tb_book")
@SuppressWarnings("serial")
public class Book extends UniversallyUniqueIdentifier{

    // Fields

     private String name;
     private String bokNo;
     private String author;
     private String publishDate;
     private String publisherName;
     private String workshop;
     private Integer price;
     private String isbn;
     private String category;
     private String bokPath;
     private String picPath;
     private Integer pageNum;
     private String authorInfo;
     private String bokInfo;
     private Integer chpNum;
     private String publishYear;
     private Integer bokType;
     private String bokDir;
     private String bokTag;
     private Date createTime;
     private List<Chapter> chapters;


    // Constructors

    /** default constructor */
    public Book() {
    }
    
    @Column(name="name", length=256)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="bok_no", length=32)

    public String getBokNo() {
        return this.bokNo;
    }
    
    public void setBokNo(String bokNo) {
        this.bokNo = bokNo;
    }
    
    @Column(name="author", length=128)

    public String getAuthor() {
        return this.author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    @Column(name="publish_date", length=32)

    public String getPublishDate() {
        return this.publishDate;
    }
    
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    
    @Column(name="publisher_name", length=256)
    public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	@Column(name="workshop", length=128)
	public String getWorkshop() {
		return workshop;
	}

	public void setWorkshop(String workshop) {
		this.workshop = workshop;
	}

	@Column(name="price", nullable=false)

    public Integer getPrice() {
        return this.price;
    }
    
    public void setPrice(Integer price) {
        this.price = price;
    }
    
    @Column(name="isbn", length=32)

    public String getIsbn() {
        return this.isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    @Column(name="category", length=256)

    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    @Column(name="bok_path", length=256)

    public String getBokPath() {
        return this.bokPath;
    }
    
    public void setBokPath(String bokPath) {
        this.bokPath = bokPath;
    }
    
    @Column(name="pic_path", length=256)

    public String getPicPath() {
        return this.picPath;
    }
    
    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
    
    @Column(name="page_num", nullable=false)

    public Integer getPageNum() {
        return this.pageNum;
    }
    
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
    
    @Column(name="author_info", length=65535)

    public String getAuthorInfo() {
        return this.authorInfo;
    }
    
    public void setAuthorInfo(String authorInfo) {
        this.authorInfo = authorInfo;
    }
    
    @Column(name="bok_info", length=65535)

    public String getBokInfo() {
        return this.bokInfo;
    }
    
    public void setBokInfo(String bokInfo) {
        this.bokInfo = bokInfo;
    }
    
    @Column(name="chp_num", nullable=false)

    public Integer getChpNum() {
        return this.chpNum;
    }
    
    public void setChpNum(Integer chpNum) {
        this.chpNum = chpNum;
    }
    
    @Column(name="publish_year", length=16)

    public String getPublishYear() {
        return this.publishYear;
    }
    
    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }
    
    @Column(name="bok_type", nullable=false)

    public Integer getBokType() {
        return this.bokType;
    }
    
    public void setBokType(Integer bokType) {
        this.bokType = bokType;
    }
    
    @Column(name="bok_dir", length=512)

    public String getBokDir() {
        return this.bokDir;
    }
    
    public void setBokDir(String bokDir) {
        this.bokDir = bokDir;
    }
    
    @Column(name="bok_tag", length=256)

    public String getBokTag() {
        return this.bokTag;
    }
    
    public void setBokTag(String bokTag) {
        this.bokTag = bokTag;
    }
    
    @Column(name = "create_time")
	@Temporal(TemporalType.DATE)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
    @OneToMany(cascade=CascadeType.ALL, mappedBy="book")
	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}

}