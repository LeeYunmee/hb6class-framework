package com.hb.action;

import com.opensymphony.xwork2.ActionSupport;

public class Ex03 extends ActionSupport{
	private String msg;
	
	public String getMsg() {
		return this.msg;
	}
	
	@Override
	public String execute() throws Exception {
	
		msg="�̷��� ����";	
		return this.SUCCESS;
	}
}
