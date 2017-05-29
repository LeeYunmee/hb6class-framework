package com.hb.day003.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.day003.model.SimpleDAO;
import com.hb.day003.support.MyController;

public class UpdateOne implements MyController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		if(!"POST".equals(req.getMethod())){
			return "err";
		}
		
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String nalja = req.getParameter("nalja");
		int sabun = Integer.parseInt(req.getParameter("sabun"));
		int pay = Integer.parseInt(req.getParameter("pay"));
		
		System.out.println("¼öÁ¤ : " + sabun + ":" + name + ":" + nalja + ":" + pay);
		
		SimpleDAO dao = new SimpleDAO();
		int result = 0;
		
		try {
			result = dao.updateOne(sabun, name, nalja, pay);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(result>0){
			System.out.println("result : " + result);
			return "redirect:edit.do?idx="+sabun;
		}else{
			return "redirect:list.do";
		}
		
		
	}

	
	
	
}
