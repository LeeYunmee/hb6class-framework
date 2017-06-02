package com.hb.sts.day01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.sts01.model.SimpleDao;

public class DetailController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse re) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		SimpleDao dao = new SimpleDao();
		int sabun = Integer.parseInt(req.getParameter("idx"));
		
		mav.addObject("bean", dao.selectOne(sabun));
		String path = req.getRequestURI().replace(req.getContextPath(), "");
		if(path.equals("/detail.do")){
			mav.setViewName("detail");
		}else if(path.equals("/edit.do")){
			mav.setViewName("edit");
		}
		return mav;
	}

}
