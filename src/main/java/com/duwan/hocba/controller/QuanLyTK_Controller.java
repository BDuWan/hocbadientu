package com.duwan.hocba.controller;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.duwan.hocba.dao.UserDao;
import com.duwan.hocba.object.UserObject;

import jakarta.servlet.http.HttpSession;

@Controller
public class QuanLyTK_Controller {
	private final UserDao userDao;

	public QuanLyTK_Controller(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@GetMapping("/quanlytaikhoan/capnhatthongtin")
	public String showCapNhatTT(HttpSession session, Model model) {
	    String username = (String) session.getAttribute("current_username");
	    if (username != null) {	    	
	    	UserObject user = userDao.getUserByTendangnhap(username);
	        model.addAttribute("user", user);
	        return "capnhatthongtin";
	    } else {
	        return "redirect:/login";
	    }
	}
	
	@PostMapping("/quanlytaikhoan/capnhatthongtin")
	public String processUpdate(
			HttpSession session,
			@RequestParam("hoten") String hoten,
		    @RequestParam("email") String email,
		    @RequestParam("sdt") String sdt,
		    @RequestParam("diachi") String diachi,
		    @RequestParam("ngaysinh") Date ngaysinh,
		    @RequestParam("gioitinh") int gioitinh) {  
		String username = (String) session.getAttribute("current_username");
		userDao.updateUserByTDN(hoten, sdt, email, diachi, ngaysinh, gioitinh, username);
		return "redirect:/quanlytaikhoan/capnhatthongtin";
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
	
	@GetMapping("/quanlytaikhoan/dangxuat")
	public String showDangXuatPage(HttpSession session, Model model) {
		String username = (String) session.getAttribute("current_username");
	    if (username != null) {	    	
	    	UserObject user = userDao.getUserByTendangnhap(username);
	        model.addAttribute("user", user);
	        return "dangxuat";
	    } else {
	        return "redirect:/login";
	    }
	}
}
