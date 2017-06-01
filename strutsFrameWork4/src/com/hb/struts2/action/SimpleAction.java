package com.hb.struts2.action;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.hb.struts2.model.SimpleDAO;
import com.hb.struts2.model.SimpleVO;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class SimpleAction implements ModelDriven<SimpleVO>, Preparable{
	private Logger log= Logger.getLogger(this.getClass());
	SimpleDAO dao = new SimpleDAO();
	private List<SimpleVO> list;
	private int sabun;
	private SimpleVO bean;
	private String msg;
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	
	public SimpleVO getBean() {
		return bean;
	}
	
	public List<SimpleVO> getList() {
		return list;
	}

	public void setList(List<SimpleVO> list) {
		this.list = list;
	}

	public String execute(){
		return"errors";
	}

	public String list(){
		dao = new SimpleDAO();
		try {
			list=dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String add(){
		return "success";
	}
	public String detail(){
		log.debug("sabun:" + sabun);
		try {
			bean = dao.selectOne(sabun);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String edit(){
		return "success";
	}
	public String insert(){
		try {
			dao.insertOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String update(){
		log.debug("update() - bean : " + bean); 
		int result=0;
		try {
			result = dao.updateOne(bean);
			log.debug("update() - result : " + result); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result>0)
			return "success";
		else
			return "input";
	}
	
	public String delete(){
		int result=0;
		try {
			result = dao.deleteOne(sabun);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result>0)
			return "success";
		else
			return "input";
	}

	@Override
	public SimpleVO getModel() {
		return bean;
	}

	@Override
	public void prepare() throws Exception {
		bean = new SimpleVO();
	}
	
}
