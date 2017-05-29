package com.hb.day003.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.day003.model.SimpleDAO;
import com.hb.day003.support.MyController;

public class SelectAll implements MyController {

	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			SimpleDAO dao = new SimpleDAO();
			List list = dao.selectAll();
			req.setAttribute("alist", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "list";
	}

	
	
}
