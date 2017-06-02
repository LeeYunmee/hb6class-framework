package com.hb.struts.action;

import org.apache.log4j.Logger;

import com.hb.struts.model.SimpleDao;
import com.hb.struts.model.SimpleVo;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport {
	Logger log = Logger.getLogger(this.getClass());
	SimpleVo bean = new SimpleVo();
	
	public void setBean(SimpleVo bean) {
		this.bean = bean;
	}
	
	public SimpleVo getBean() {
		return bean;
	}

	@Override
	public String execute() throws Exception {
		log.debug(bean);
		
		SimpleDao dao = new SimpleDao();
		int result = dao.updateOne(bean);
		
		if(result>0) 
		return this.SUCCESS;
		else
		return this.INPUT;	
	}
}
