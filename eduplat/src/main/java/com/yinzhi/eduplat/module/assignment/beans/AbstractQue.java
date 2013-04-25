package com.yinzhi.eduplat.module.assignment.beans;

/**
 * 题目抽象类
 * 
 * @author 黄清泉
 * @date 2013-4-3
 */
public abstract class AbstractQue {

	private String id;
	private String content;
	private String answer;

	public AbstractQue(){
		
	}
	
	public AbstractQue(String id, String content, String answer) {
		super();
		this.id = id;
		this.content = content;
		this.answer = answer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
