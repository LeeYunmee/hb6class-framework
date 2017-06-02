package com.hb.struts.action;

import com.hb.struts.model.SimpleDao;
import com.hb.struts.model.SimpleVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class InsertOneAction implements Action{
	/*private int sabun, pay;
	private String name;
	
	

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}



	public void setPay(int pay) {
		this.pay = pay;
	}



	public void setName(String name) {
		this.name = name;
	}*/
	
	SimpleVo bean = new SimpleVo();
	
	

	public SimpleVo getBean(){
		return bean;
	}



	public void setBean(SimpleVo bean) {
		this.bean = bean;
	}



	@Override
	public String execute() throws Exception {
		SimpleDao dao = new SimpleDao();
		
//		int result = dao.insertOne(sabun, name, pay);
		int result = dao.insertOne(bean);
		if(result>0)
			return SUCCESS;
		else
			return INPUT;
	}

	
	
}
