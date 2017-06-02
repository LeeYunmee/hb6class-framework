package com.hb.struts.action;

import org.apache.log4j.Logger;

import com.hb.struts.model.SimpleDao;
import com.hb.struts.model.SimpleVo;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction2 extends ActionSupport {
	Logger log = Logger.getLogger(this.getClass());
	SimpleVo bean = new SimpleVo();
	
	public UpdateAction2()
	{
		log.debug("debug.UpdateAction2() called");
	}
	
	public void setBean(SimpleVo bean) {
		log.debug("debug.setBean() called");
		this.bean = bean;
	}
	
	public SimpleVo getBean() {
		log.debug("debug.getBean() called");
		return bean;
	}

	@Override
	public void validate() {
		log.debug("debug.validate() called");
		String name = bean.getName();
		
		//log.debug("debug.validate() name=["+name+"]");
		addFieldError("name", "test!");
		
		if(name.equals("")){
			log.debug("in if case");
			
			addFieldError("bean.name", "이름입력");
		}
	}
	
	@Override
	public String execute() throws Exception {
		log.debug("debug.execute() called");
		log.debug(bean);
		return super.execute();
		
	}
}
