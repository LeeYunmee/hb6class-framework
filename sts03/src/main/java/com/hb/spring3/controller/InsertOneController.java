package com.hb.spring3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.spring3.model.SimpleDao;
import com.hb.spring3.model.SimpleVo;

public class InsertOneController implements Controller {
	@Autowired
	private SimpleDao dao;
	
	/*public void setDao(SimpleDao dao) {
		this.dao = dao;
	}*/
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		int sabun = Integer.parseInt(req.getParameter("sabun"));
		String name = req.getParameter("name");
		int pay = Integer.parseInt(req.getParameter("pay"));
		
		SimpleVo bean = new SimpleVo();
		bean.setSabun(sabun);
		bean.setName(name);
		bean.setPay(pay);

		dao.insertOne(bean);
		mav.setViewName("redirect: list.do");
		return mav;
	}

}
