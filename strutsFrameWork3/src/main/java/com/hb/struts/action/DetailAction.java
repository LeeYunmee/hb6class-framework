package com.hb.struts.action;

import com.hb.struts.model.SimpleDao;
import com.hb.struts.model.SimpleVo;
import com.opensymphony.xwork2.Action;

public class DetailAction implements Action {
	private SimpleVo bean;
	private int sabun;
	private String errname;
	
	
	
	public String getErrname() {
		return errname;
	}

	public void setErrname(String errname) {
		this.errname = errname;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	
	public SimpleVo getBean() {
		return bean;
	}
	
	@Override
	public String execute() throws Exception {
		
		SimpleDao dao = new SimpleDao();
		bean = dao.selectOne(sabun);
		
		return "success";
	}

}
