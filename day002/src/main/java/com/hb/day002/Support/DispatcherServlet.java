package com.hb.day002.Support;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.day002.Controller.MyController;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	
//	
//	@Override
//	public void init() throws ServletException {
//		
//		super.init();
//		HandlerMapping.setMap("/day002/*.do","com.hb.day002.Controller.ListController");
//		HandlerMapping.setMap("/day002/list.do","com.hb.day002.Controller.ListController");
//		HandlerMapping.setMap("/day002/add.do","com.hb.day002.Controller.AddController");
//		HandlerMapping.setMap("/day002/insert.do","com.hb.day002.Controller.InsertController");
//	}
//	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		HandlerMapping.setMap("/day002/*.do","com.hb.day002.Controller.ListController");
		HandlerMapping.setMap("/day002/list.do","com.hb.day002.Controller.ListController");
		HandlerMapping.setMap("/day002/add.do","com.hb.day002.Controller.AddController");
		HandlerMapping.setMap("/day002/insert.do","com.hb.day002.Controller.InsertController");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//    	/list.do  		,get  -> 	/page/list.jsp      						->  return "list"
				// 		/detail.do  	,get  -> 	/page/detail.jsp   							-> return "detail"
				//		/ add.do   		,get  -> 	/page/form.jsp   							-> return "form"
				//		/insert.do 		,post -> 	redirect(데이터처리하는 페이지): list.do	-> redirect:list
				//		/edit.do  		,get  ->	/page/form.jsp 재사용						-> return "form"
				//		/update.do 		,post -> 	redirect(데이터처리하는 페이지): detail.do  -> redirect:detail
				//		/del.do  		,post ->  	redirect(데이터처리하는 페이지): detail.do  -> redirect:detail
		
		
			// controller 선택
				String uri = request.getRequestURI();
//				System.out.println(uri);
				MyController controller = HandlerMapping.mapping(uri);
				String pname = controller.execute(request, response);
	
			// view
				String url=null;	
				if(pname.startsWith("redirect:")){
									url=pname.replace("redirect:", "");
									response.sendRedirect(url);
									return;
						}
				
				String prifix="/page/";
				String sufix=".jsp";
				url=prifix+pname+sufix;
				request.getRequestDispatcher(url).forward(request, response);
	
	}

}
