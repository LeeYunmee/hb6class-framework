package com.hb.spring3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.spring3.model.SimpleDao;

public class SelectOneController implements Controller{
	@Autowired
	private SimpleDao dao;
	
/*	public void setDao(SimpleDao dao) {
		this.dao = dao;
	}
*/	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = null;
		System.out.println(req.getRequestURI());
		if(req.getRequestURI().equals("/sts03/detail.do"))
			mav = new ModelAndView("detail");
		else if(req.getRequestURI().equals("/sts03/edit.do"))
			mav = new ModelAndView("edit");
		String temp = "sabun";
		mav.addObject("bean", dao.selectOne(Integer.parseInt(req.getParameter("sabun"))));
		return mav;
	}

}
