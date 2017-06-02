package com.hb.struts.action;

import org.apache.log4j.Logger;

import com.hb.struts.model.SimpleDao;
import com.hb.struts.model.SimpleVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class InsertOneAction3 implements Action, ModelDriven, Preparable{
	private Logger log;
	private SimpleVo bean;
	
	@Override
	public Object getModel() {
		return bean;
	}

	@Override
	public void prepare() throws Exception {
		bean = new SimpleVo();
		log=Logger.getLogger(this.getClass());
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
