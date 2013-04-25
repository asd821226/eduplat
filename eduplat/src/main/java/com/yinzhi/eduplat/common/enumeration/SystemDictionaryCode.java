package com.yinzhi.eduplat.common.enumeration;

/**
 * 字典类型枚举
 * @author 黄清泉
 * @date 2013-3-14
 */
public enum SystemDictionaryCode {
	
	/**
	 * 状态类型
	 */
	State("state"),
	
	/**
	 * 资源类型
	 */
	ResourceType("resource-type"),
	
	/**
	 * 组类型
	 */
	GroupType("group-type"),
	
	/**
	 * 属性值类型
	 */
	ValueType("value-type"),
	
	/**
	 * 性别类型
	 */
	SexType("sex-type");
	
	
	private String code;
	
	private SystemDictionaryCode(String code) {
		this.code = code;
	}
	
	/**
	 * 获取类型代码
	 * 
	 * @return String
	 */
	public String getCode() {
		return this.code;
	}
}
