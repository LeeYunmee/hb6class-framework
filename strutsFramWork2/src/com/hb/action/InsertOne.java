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
		System.out.println("1�̸� ����"+result);
	//	result=0; // ���� test
		if(result>0)
			return this.SUCCESS;
/*		return this.SUCCESS; // �������� ��
		return this.NONE; // ��Ʈ�ѷ��� ���۽�ų ��
		return this.ERROR; 
		return this.INPUT; //���Է�s�� ���� ��
		return this.LOGIN; //INPUT�� ����
*/		else
			return this.ERROR;
	}
	
}
