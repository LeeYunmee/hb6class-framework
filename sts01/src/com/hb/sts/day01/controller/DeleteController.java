package com.hb.sts.day01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.sts01.model.SimpleDao;

public class DeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		SimpleDao dao = new SimpleDao();
		String msg = null;
		
		if(dao.deleteOne(Integer.parseInt(req.getParameter("idx")))>0){
			msg="success";
		}else{
			msg="fail";
		}
			mav.setViewName("redirect:list.do?display=true&msg="+msg);
/*		
		if(dao.deleteOne(Integer.parseInt(req.getParameter("idx")))>0){
			mav.setViewName("redirect:list.do");
		}else{
			mav.setViewName("redirect:detail.do?idx="+req.getParameter("idx"));
		}
		*/
		return mav;
	}

}
