package com.hb.day003.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.day003.model.SimpleDAO;
import com.hb.day003.model.SimpleVO;
import com.hb.day003.support.MyController;

public class EditForm implements MyController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("title", "¼öÁ¤");
		req.setAttribute("nxtURI", "update.do");
		String idx = req.getParameter("idx");
		SimpleDAO dao = new SimpleDAO();
		try{
			int sabun = Integer.parseInt(idx);
			SimpleVO bean = dao.selectOne(sabun);
			req.setAttribute("bean", bean);
		}catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		return "form";
	}

	
	
	
}
