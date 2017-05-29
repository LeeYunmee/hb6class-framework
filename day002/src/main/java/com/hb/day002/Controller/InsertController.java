package com.hb.day002.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.day002.Model.SimpleDao;
import com.hb.day002.Model.SimpleVo;

public class InsertController implements MyController {
	
	
@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		if(!"POST".equals(request.getMethod())){
			request.setAttribute("msg", "잘못된 접근입니다."); // 주소창에서 직접 입력하는 방식에 대한 제한, 보안
			return "form";
		}
	
			Map<String, String> errs = new HashMap<>();
			String param1=request.getParameter("name");
			String param2=request.getParameter("nalja");
			String param3=request.getParameter("pay");
			
			SimpleVo vo = new SimpleVo();
			vo.setName(param1);
			vo.setNalja(param2);
			
			try{
				vo.setPay(Integer.parseInt(param3));
			}catch (Exception e){
//				request.setAttribute("errPay", "pay의 입력확인");
//				request.setAttribute("bean", vo);
//				return "form";
				errs.put("pay", "금액입력");
			}
			if(param1.equals("")){
//				request.setAttribute("errNm", "빈칸입력");
//				request.setAttribute("bean", vo);
//				return "form";
				errs.put("name", "이름입력");
			}
			if(param2.equals("")){
//				request.setAttribute("errNL", "빈칸입력");
//				request.setAttribute("bean", vo);
//				return "form";
				errs.put("nalja", "날짜입력");
			}	
			if(!errs.isEmpty()){
				request.setAttribute("bean", vo);
				request.setAttribute("err", errs);
				return "form";
				
			}
				
			SimpleDao dao = new SimpleDao();
			int result=0;
			try {
				result = dao.insertOne(vo);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
			if(result>0)
				return "redirect:list.do";
			else
				return "add";
	}	

}
