package com.hb.struts.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.hb.struts.model.SimpleDao;
import com.hb.struts.model.SimpleVo;
import com.opensymphony.xwork2.Action;

public class ListAction implements Action{
	Logger log = Logger.getLogger(this.getClass());
	private List<SimpleVo> alist;
	
	public List<SimpleVo> getAlist() {
		return alist;
	}

	@Override
	public String execute() throws Exception {
		log.debug("리스트 action 수행");
/*		SimpleDao dao = new SimpleDao();
		alist = dao.selectAll();*/
		alist = new SimpleDao().selectAll();
		return SUCCESS;
	}

}
