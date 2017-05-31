package com.hb.action;

import com.hb.model.SimpleDAO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteOne extends ActionSupport {
	private int sabun;
	
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("start");
		SimpleDAO dao = new SimpleDAO();
		int result =  dao.deleteOne(sabun);
		System.out.println(sabun);
		if(result>0) {
//			System.out.println(result);
			return this.SUCCESS;
		}
		else
		return this.ERROR;
	}

}
