package com.yinzhi.eduplat.entity.finance;

import java.util.Date;

/**
 * 中介构建类，当前课程
 * @author 黄清泉
 * @date 2013-3-23
 */
public class CorTec {

	private String id;
	private String corName;
	private String corPic;
	private String tecName;
	private String tecSchool;
	private Date startDate;
	private Date endDate;
	private long stuNum;
	
	public CorTec(){
	}
	
	public CorTec(String id, String corName, String corPic, String tecName,
			String tecScool, Date startDate, Date endDate, long stuNum) {
		super();
		this.id = id;
		this.corName = corName;
		this.corPic = corPic;
		this.tecName = tecName;
		this.tecSchool = tecScool;
		this.startDate = startDate;
		this.endDate = endDate;
		this.stuNum = stuNum;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCorName() {
		return corName;
	}
	public void setCorName(String corName) {
		this.corName = corName;
	}
	public String getCorPic() {
		return corPic;
	}
	public void setCorPic(String corPic) {
		this.corPic = corPic;
	}
	public String getTecName() {
		return tecName;
	}
	public void setTecName(String tecName) {
		this.tecName = tecName;
	}
	public String getTecScool() {
		return tecSchool;
	}
	public void setTecScool(String tecScool) {
		this.tecSchool = tecScool;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public long getStuNum() {
		return stuNum;
	}
	public void setStuNum(long stuNum) {
		this.stuNum = stuNum;
	}
	
	
}
