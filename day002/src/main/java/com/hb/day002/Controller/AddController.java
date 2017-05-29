package com.hb.day002.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddController implements MyController {

			@Override
			public String execute(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				
				return "form";
			}
	
}
