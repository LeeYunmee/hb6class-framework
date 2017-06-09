package com.hb.stsday02.userController;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hb.stsday02.userModel.GuestUserDao;
import com.hb.stsday02.userModel.GuestUserVo;

@Controller
public class GuestUserController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private GuestUserDao<GuestUserVo> guestUserDao;
	
	@RequestMapping("/user/list")
	public void selectAll(Model model){
		log.debug(model);
		try {
			model.addAttribute("alist", guestUserDao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/user/detail")
	public void selectOne(Model model, @RequestParam int idx){
		try {
			model.addAttribute("bin", guestUserDao.selectOne(idx));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/user/add", method=RequestMethod.GET)
	public String addForm(Model model){
		
		return "user/form";
	}
	
	@RequestMapping(value="/user/add", method=RequestMethod.POST)
	public String insertOne(@ModelAttribute GuestUserVo bean){
		log.debug(bean);
		try {
			guestUserDao.insertOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}

	
	
}
