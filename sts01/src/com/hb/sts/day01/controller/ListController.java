package com.hb.sts.day01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.sts01.model.SimpleDao;

public class ListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		SimpleDao dao = new SimpleDao();
		
		mav.addObject("alist", dao.selectAll());
		mav.setViewName("list");
		
		return mav;
	}

}
