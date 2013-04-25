package com.yinzhi.eduplat.common.enumeration.entity;

public enum SexType {
	/**
	 * 男
	 */
	Male("01","男"),
	/**
	 * 女
	 */
	Female("02","女");
	
	
	private SexType(String value,String name) {
		this.value = value;
		this.name = name;
	}
	
	private String value;
	
	private String name;

	/**
	 * 获取类型值
	 * 
	 * @return String
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 获取类型名称
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}
}
