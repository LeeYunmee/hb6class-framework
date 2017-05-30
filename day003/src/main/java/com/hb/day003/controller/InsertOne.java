package com.hb.day003.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.day003.model.SimpleDAO;
import com.hb.day003.support.MyController;

public class InsertOne implements MyController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(!"POST".equals(req.getMethod())){
			return "err";
		}
		req.setCharacterEncoding("UTF-8");
		SimpleDAO dao = new SimpleDAO();
		
		try{
			String name = req.getParameter("name");
			String nalja = req.getParameter("nalja");
			int pay = Integer.parseInt(req.getParameter("pay"));
			
			int result = dao.insertOne(name,nalja,pay);
			
			if(result > 0){
				return "redirect:list.do";
			}else{
				req.setAttribute("title", "입력");
				req.setAttribute("nxtURI", "insert.do");
				return "form";
			}
		}catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("title", "입력");
			req.setAttribute("nxtURI", "insert.do");
			return "form";
		}
	}

	
	
}
