package com.hb.day002.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.day002.Model.SimpleDao;

public class ListController implements MyController{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getMethod());
		SimpleDao dao = new SimpleDao();
				try {
						request.setAttribute("alist", dao.selectAll());
					} catch (SQLException e) {
						e.printStackTrace();
				}
		
	    	return "list";
	}
	
}
