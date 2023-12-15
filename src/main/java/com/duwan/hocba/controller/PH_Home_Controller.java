package com.duwan.hocba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.duwan.hocba.interfac.UserInterface;
import com.duwan.hocba.object.UserObject;

import jakarta.servlet.http.HttpSession;

@Controller
public class PH_Home_Controller {
	private final UserInterface userInterface;

	public PH_Home_Controller(UserInterface userInterface) {
		this.userInterface = userInterface;
	}
	
	@GetMapping("/phuhuynh")
	public String showHSPage(HttpSession session, Model model) {
	    String username = (String) session.getAttribute("current_username");
	    if (username != null) {	    	
	    	UserObject user = userInterface.getUserByTendangnhap(username);
	        model.addAttribute("user", user);
	        return "phuhuynh";
	    } else {
	        return "redirect:/login";
	    }
	}
}
