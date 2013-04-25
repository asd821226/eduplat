package com.yinzhi.eduplat.entity.finance;

/**
 * 中介构建类，本班课件
 * @author 黄清泉
 * @date 2013-3-23
 */
public class CorCwr {

	private String corId;
	private String cwrId;
	private String chpId;
	private int chpOrder;
	private String cwrName;
	private String chpName;
	
	public CorCwr(){
	}
	
	
	public CorCwr(String corId, String cwrId, String chpId, int chpOrder,
			String cwrName, String chpName) {
		super();
		this.corId = corId;
		this.cwrId = cwrId;
		this.chpId = chpId;
		this.chpOrder = chpOrder;
		this.cwrName = cwrName;
		this.chpName = chpName;
	}


	public String getCorId() {
		return corId;
	}
	public void setCorId(String corId) {
		this.corId = corId;
	}
	public String getCwrId() {
		return cwrId;
	}
	public void setCwrId(String cwrId) {
		this.cwrId = cwrId;
	}
	public String getChpId() {
		return chpId;
	}
	public void setChpId(String chpId) {
		this.chpId = chpId;
	}
	public int getChpOrder() {
		return chpOrder;
	}
	public void setChpOrder(int chpOrder) {
		this.chpOrder = chpOrder;
	}
	public String getCwrName() {
		return cwrName;
	}
	public void setCwrName(String cwrName) {
		this.cwrName = cwrName;
	}
	public String getChpName() {
		return chpName;
	}
	public void setChpName(String chpName) {
		this.chpName = chpName;
	}
	
	
	
}
