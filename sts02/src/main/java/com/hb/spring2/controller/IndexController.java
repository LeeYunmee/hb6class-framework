package com.hb.spring2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		if("sts02/index.do".equals(req.getRequestURI()))
		mav.setViewName("main");
		else if("/sts02/add.do".equals(req.getRequestURI()))
		mav.setViewName("add");
		return mav;
	}

	
	
}
