package com.hb.sts.day01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.sts01.model.SimpleDao;
import com.hb.sts01.model.SimpleVo;

public class InsertController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
	if(req.getMethod().equals("POST")){
		System.out.println("start");
		req.setCharacterEncoding("UTF-8");
		SimpleDao dao = new SimpleDao();
		SimpleVo bean = new SimpleVo(Integer.parseInt(req.getParameter("sabun")), 
				req.getParameter("name"), 
				null, 
				Integer.parseInt(req.getParameter("pay")));
		
		if(dao.insertOne(bean)>0)
		mav.setViewName("redirect:list.do");
		else
			mav.setViewName("add");
	}else{
		mav.setViewName("add");
	}
	return mav;
	}

}
