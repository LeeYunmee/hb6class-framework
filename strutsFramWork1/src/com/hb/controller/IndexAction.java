package com.hb.controller;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		
//		return super.execute();
		return this.SUCCESS; //오타 방지목적으로 상수로 제공함
	}
	
}
