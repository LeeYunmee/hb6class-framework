package com.hb.action;

import java.util.Map;

import com.hb.model.SimpleDAO;
import com.opensymphony.xwork2.ActionSupport;

public class SelectOne extends ActionSupport{
	private int sabun;
	private Map<String, Object> bean;
	
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	
	public Map<String, Object> getBean() {
		return bean;
	}

	@Override
	public String execute() throws Exception {
//	System.out.println(sabun);
		SimpleDAO dao = new SimpleDAO();
		bean = dao.selectOne(sabun);
		
		return this.SUCCESS;
	}
}
