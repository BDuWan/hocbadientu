package com.duwan.hocba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.duwan.hocba.dao.UserDao;
import com.duwan.hocba.object.UserObject;

import jakarta.servlet.http.HttpSession;

@Controller
public class QuanLyTK_Controller {
	private final UserDao userDao;

	public QuanLyTK_Controller(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@GetMapping("/quanlytaikhoan")
	public String showQLTK(HttpSession session, Model model) {
	    String username = (String) session.getAttribute("current_username");
	    if (username != null) {	    	
	    	UserObject user = userDao.getUserByTendangnhap(username);
	        model.addAttribute("user", user);
	        return "quanlytaikhoan";
	    } else {
	        return "redirect:/login";
	    }
	}
	
	@GetMapping("/quanlytaikhoan/doimatkhau")
	public String showDoiMK(HttpSession session, Model model) {
	    String username = (String) session.getAttribute("current_username");
	    if (username != null) {	    	
	    	UserObject user = userDao.getUserByTendangnhap(username);
	        model.addAttribute("user", user);
	        return "doimatkhau";
	    } else {
	        return "redirect:/login";
	    }
	}
}
