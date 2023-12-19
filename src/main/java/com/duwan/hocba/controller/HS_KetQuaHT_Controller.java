package com.duwan.hocba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.duwan.hocba.dao.UserDao;
import com.duwan.hocba.object.UserObject;

import jakarta.servlet.http.HttpSession;

@Controller
public class HS_KetQuaHT_Controller {
	private final UserDao userDao;

	public HS_KetQuaHT_Controller(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@GetMapping("/hocsinh/ketquahoctap")
	public String showHSPage(HttpSession session, Model model) {
	    String username = (String) session.getAttribute("current_username");
	    if (username != null) {	    	
	    	UserObject user = userDao.getUserByTendangnhap(username);
	        model.addAttribute("user", user);
	        return "hocsinh_ketquahoctap";
	    } else {
	        return "redirect:/login";
	    }
	}
}
