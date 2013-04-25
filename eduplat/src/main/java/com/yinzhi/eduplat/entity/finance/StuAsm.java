package com.yinzhi.eduplat.entity.finance;

/**
 * 中介构建类，学生答题情况
 * @author 黄清泉
 * @date 2013-3-23
 */
public class StuAsm {

	private String stuId;
	private String assId;
	private String stuNo;
	private String stuName;
	private Integer asmScore;
	
	public StuAsm(){
	}
	
	public StuAsm(String stuId, String assId, String stuNo, String stuName,
			Integer asmScore) {
		super();
		this.stuId = stuId;
		this.assId = assId;
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.asmScore = asmScore;
	}

	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getAssId() {
		return assId;
	}
	public void setAssId(String assId) {
		this.assId = assId;
	}
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public Integer getAsmScore() {
		return asmScore;
	}
	public void setAsmScore(Integer asmScore) {
		this.asmScore = asmScore;
	}
	
}
