package com.hb.action;

import com.hb.model.SimpleDAO;
import com.hb.util.MyOracle;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateOne extends ActionSupport {
		 private String name, nalja;
		 private int sabun, pay;
	
		 
		 
	public void setName(String name) {
			this.name = name;
		}



		public void setNalja(String nalja) {
			this.nalja = nalja;
		}



		public void setSabun(int sabun) {
			this.sabun = sabun;
		}



		public void setPay(int pay) {
			this.pay = pay;
		}



	@Override
	public String execute() throws Exception {
		
		SimpleDAO dao = new SimpleDAO();
		int result = dao.updateOne(sabun, name, nalja, pay);
		
		if(result>0)
		return this.SUCCESS;
		else
		return this.ERROR;
	}
}
