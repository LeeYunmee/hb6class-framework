package com.hb.spring3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.spring3.model.SimpleDao;
import com.hb.spring3.model.SimpleVo;

public class UpdateOneController implements Controller {
	@Autowired
	private SimpleDao dao;
	
/*	public void setDao(SimpleDao dao) {
		this.dao = dao;
	}*/
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = null;
		SimpleVo bean = new SimpleVo();
		bean.setSabun(Integer.parseInt(req.getParameter("sabun")));
		bean.setName(req.getParameter("name"));
		bean.setPay(Integer.parseInt(req.getParameter("pay")));
		
		int result = dao.updateOne(bean);
		
		if(result>0){
			mav = new ModelAndView("redirect:list.do");
		}else{
			mav = new ModelAndView("redirect:edit.do?sabun="+bean.getSabun());
		}
		return mav;
	}

}
