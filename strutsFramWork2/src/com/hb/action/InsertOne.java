package com.hb.action;

import com.hb.model.SimpleDAO;
import com.opensymphony.xwork2.ActionSupport;

public class InsertOne extends ActionSupport {
	private String name,nalja;
	private int pay;
	
	

	public void setName(String name) {
		this.name = name;
	}



	public void setNalja(String nalja) {
		this.nalja = nalja;
	}



	public void setPay(int pay) {
		this.pay = pay;
	}

	@Override
	public String execute() throws Exception {
		
		SimpleDAO dao = new SimpleDAO();
		int result = dao.insertOne(name,nalja,pay);
		System.out.println("1이면 성공"+result);
	//	result=0; // 에러 test
		if(result>0)
			return this.SUCCESS;
/*		return this.SUCCESS; // 성공했을 때
		return this.NONE; // 컨트롤러만 동작시킬 때
		return this.ERROR; 
		return this.INPUT; //재입력s을 받을 때
		return this.LOGIN; //INPUT과 동일
*/		else
			return this.ERROR;
	}
	
}
