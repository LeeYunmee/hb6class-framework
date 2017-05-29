package com.hb.day003.support;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MyController {
	
	 String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException; //메소드 정의
		
}
