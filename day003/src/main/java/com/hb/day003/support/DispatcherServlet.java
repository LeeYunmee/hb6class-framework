package com.hb.day003.support;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet{	
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		Properties prop = new Properties();
		InputStream is = getClass().getClassLoader().getResourceAsStream("bean.properties");
		if(is!=null){
			try{
				prop.load(is);
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		Set<Object> obj = prop.keySet();
		Iterator<Object> ite = obj.iterator();
		while(ite.hasNext()){
			String key = (String)ite.next();
			String value = prop.getProperty(key);
			HandlerMapping.setMap(key, value);
		}
		
		
//		HandlerMapping.setMap("/list.do", "com.hb.day003.controller.SelectAll"); // bean.propertise
		
//		
//		list	list.do		get
//		detail	detail.do	get 
//
//		insert	update.do	post
//		update	update.do	put
//		delete	update.do	delete
//	
	
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// controller
		String uri = req.getRequestURI();
		MyController controller = HandlerMapping.mapping(uri);
		String path = controller.execute(req,  res);
		
		System.out.println(uri);
		
		//view
		if(path.startsWith("redirect:")){
			path = path.replace("redirect:", "");
			res.sendRedirect(path);
			return;
		}
		String prifix="/WEB-INF/page/";
		String sufix=".jsp";
		req.getRequestDispatcher(prifix+path+sufix).forward(req, res);
		
		
	}
}
