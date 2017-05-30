package com.hb.action;

import java.util.List;
import java.util.Map;

import com.hb.model.SimpleDAO;
import com.opensymphony.xwork2.ActionSupport;

public class SelectAll extends ActionSupport{
	private List<Map<String, Object>> alist;

	public List<Map<String, Object>> getAlist() {
		return alist;
	}
	
	@Override
	public String execute() throws Exception {
		
		SimpleDAO dao = new SimpleDAO();
		alist = dao.SelectAll();
		
		return this.SUCCESS;
	}
	
}
