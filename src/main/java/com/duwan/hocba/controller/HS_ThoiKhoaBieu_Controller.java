package com.duwan.hocba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.duwan.hocba.interfac.UserInterface;
import com.duwan.hocba.object.UserObject;

import jakarta.servlet.http.HttpSession;

@Controller
public class HS_ThoiKhoaBieu_Controller {
	private final UserInterface userInterface;

	public HS_ThoiKhoaBieu_Controller(UserInterface userInterface) {
		this.userInterface = userInterface;
	}
	
	@GetMapping("/hocsinh/thoikhoabieu")
	public String showHS_TKBPage(HttpSession session, Model model) {
	    String username = (String) session.getAttribute("current_username");
	    if (username != null) {	    	
	    	UserObject user = userInterface.fetchUserByTendangnhap(username);
	        model.addAttribute("user", user);
	        return "hocsinh_thoikhoabieu";
	    } else {
	        return "redirect:/login";
	    }
	}
}
