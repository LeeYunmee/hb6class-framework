package com.hb.sts01.model;

import java.util.Date;

public class SimpleVo {
	int sabun, pay;
	String name;
	Date nalja;
	
	public SimpleVo() {
	}
	
	

	public SimpleVo(int sabun, String name, Date nalja, int pay) {
		super();
		this.sabun = sabun;
		this.pay = pay;
		this.name = name;
		this.nalja = nalja;
	}



	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getNalja() {
		return nalja;
	}

	public void setNalja(Date nalja) {
		this.nalja = nalja;
	}

	@Override
	public String toString() {
		return "SimpleVo [sabun=" + sabun + ", pay=" + pay + ", name=" + name + ", nalja=" + nalja + "]";
	}
	
	

}
