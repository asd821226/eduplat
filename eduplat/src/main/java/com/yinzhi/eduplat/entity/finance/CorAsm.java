package com.yinzhi.eduplat.entity.finance;

import java.util.Date;

/**
 * 中介构建类，本班作业
 * @author 黄清泉
 * @date 2013-3-23
 */
public class CorAsm {
	
	private String corId;
	private String asmId;
	private int chpOrder;
	private String chpName;
	private String asmName;
	private int assType;
	private Date startDate;
	private Date endDate;
	private int assStatus;
	
	public CorAsm(){
	}
	
	public CorAsm(String corId, String asmId, int chpOrder, String chpName,
			String asmName, int asmType, Date startDate, Date endDate, int assStatus) {
		super();
		this.corId = corId;
		this.asmId = asmId;
		this.chpOrder = chpOrder;
		this.chpName = chpName;
		this.asmName = asmName;
		this.assType = asmType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.assStatus = assStatus;
	}

	public String getCorId() {
		return corId;
	}

	public void setCorId(String corId) {
		this.corId = corId;
	}

	public String getAsmId() {
		return asmId;
	}

	public void setAsmId(String asmId) {
		this.asmId = asmId;
	}

	public int getChpOrder() {
		return chpOrder;
	}

	public void setChpOrder(int chpOrder) {
		this.chpOrder = chpOrder;
	}

	public String getChpName() {
		return chpName;
	}

	public void setChpName(String chpName) {
		this.chpName = chpName;
	}

	public String getAsmName() {
		return asmName;
	}

	public void setAsmName(String asmName) {
		this.asmName = asmName;
	}

	public int getAssType() {
		return assType;
	}

	public void setAssType(int assType) {
		this.assType = assType;
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

	public int getAssStatus() {
		return assStatus;
	}

	public void setAssStatus(int assStatus) {
		this.assStatus = assStatus;
	}

}
