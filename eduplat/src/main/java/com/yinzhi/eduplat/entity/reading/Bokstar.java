package com.yinzhi.eduplat.entity.reading;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yinzhi.eduplat.entity.UniversallyUniqueIdentifier;

/**
 * 评分类
 * @author 黄清泉
 * @date 2013-4-6
 */
@Entity
@Table(name = "tb_bokstar")
@SuppressWarnings("serial")
public class Bokstar extends UniversallyUniqueIdentifier {

	private Integer stars;
	private Integer stars1;
	private Integer stars2;
	private Integer stars3;
	private Integer stars4;
	private String fkBookId;
	
	public Bokstar(){
		
	}
	
	public Bokstar(String id){
		this.id = id;
	}
	
	@Column(name="stars", length=6)
	public Integer getStars() {
		return stars;
	}
	public void setStars(Integer stars) {
		this.stars = stars;
	}
	@Column(name="stars1", length=6)
	public Integer getStars1() {
		return stars1;
	}
	public void setStars1(Integer stars1) {
		this.stars1 = stars1;
	}
	@Column(name="stars2", length=6)
	public Integer getStars2() {
		return stars2;
	}
	public void setStars2(Integer stars2) {
		this.stars2 = stars2;
	}
	@Column(name="stars3", length=6)
	public Integer getStars3() {
		return stars3;
	}
	public void setStars3(Integer stars3) {
		this.stars3 = stars3;
	}
	@Column(name="stars4", length=6)
	public Integer getStars4() {
		return stars4;
	}
	public void setStars4(Integer stars4) {
		this.stars4 = stars4;
	}
	
	@Column(name="fk_book_id")
	public String getFkBookId() {
		return fkBookId;
	}
	public void setFkBookId(String fkBookId) {
		this.fkBookId = fkBookId;
	}

	
}
