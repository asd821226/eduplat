package com.yinzhi.eduplat.common.enumeration.entity;

public enum QuestionType {
	
	Quetype0(0,"单选题"),
	Quetype1(1,"多选题"),
	Quetype2(2,"填空题"),
	Quetype3(3,"简答题"),
	Quetype4(4,"辨析题"),
	Quetype5(5,"计算题"),
	Quetype6(6,"图表题"),
	Quetype7(7,"分录题");
	
	//值
	private Integer value;
	//名称
	private String name;
	
	private QuestionType(Integer value,String name) {
		this.value = value;
		this.name = name;
	}

	/**
	 * 获取值
	 * @return Integer
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * 获取名称
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
}
