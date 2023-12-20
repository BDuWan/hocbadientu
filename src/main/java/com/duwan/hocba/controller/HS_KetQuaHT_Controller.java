package com.duwan.hocba.controller;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.duwan.hocba.dao.HS_KQHT_Dao;
import com.duwan.hocba.dao.HocSinhDao;
import com.duwan.hocba.dao.UserDao;
import com.duwan.hocba.object.HS_KQHT_Object;
import com.duwan.hocba.object.HocSinhObject;
import com.duwan.hocba.object.UserObject;

import jakarta.servlet.http.HttpSession;

@Controller
public class HS_KetQuaHT_Controller {
	private final UserDao userDao;
	private final HS_KQHT_Dao kqhtDao;
	private final HocSinhDao hsDao;
	public HS_KetQuaHT_Controller(UserDao userDao, HS_KQHT_Dao kqhtDao, HocSinhDao hsDao) {
		this.userDao = userDao;
		this.kqhtDao = kqhtDao;
		this.hsDao = hsDao;
	}
	
	@GetMapping("/hocsinh/ketquahoctap")
	public String showHSPage(HttpSession session, Model model) {
	    String username = (String) session.getAttribute("current_username");
	    if (username != null) {	    	
	    	UserObject user = userDao.getUserByTendangnhap(username);
	    	HocSinhObject hocSinh = hsDao.getHocSinhByTDN(username);
	    	List<HS_KQHT_Object> list_KQHT = kqhtDao.getKqhtByHocSinhId(hocSinh.getHocsinh_id());
	        model.addAttribute("user", user);
	        model.addAttribute("list_lop", getList(5));
	        model.addAttribute("list_KQHT", list_KQHT);
	        
	        return "hocsinh_ketquahoctap_blank";
	    } else {
	        return "redirect:/login";
	    }
	}
	
	@GetMapping("/hocsinh/ketquahoctap/{lop}")
	public String showHSPageWith(HttpSession session, Model model, @PathVariable int lop) {
	    String username = (String) session.getAttribute("current_username");
	    if (username != null) {	  
	    	UserObject user = userDao.getUserByTendangnhap(username);
	    	HocSinhObject hocSinh = hsDao.getHocSinhByTDN(username);
	    	List<HS_KQHT_Object> list_KQHT = kqhtDao.getKqhtByHocSinhId(hocSinh.getHocsinh_id(), lop);
	        model.addAttribute("user", user);
	        model.addAttribute("hocsinh", hocSinh);
	        model.addAttribute("list_lop", getList(5));
	        model.addAttribute("list_ki", getList(2));
	        model.addAttribute("lop", lop);
	    	model.addAttribute("list_KQHT", list_KQHT);
	    	
	        
	        return "hocsinh_ketquahoctap";
	    } else {
	        return "redirect:/login";
	    }
	}
	
	@GetMapping("/hocsinh/ketquahoctap/{lop}/{ki}")
	public String showHSPageWith(HttpSession session, Model model, @PathVariable int lop, @PathVariable int ki) {
		String username = (String) session.getAttribute("current_username");
	    if (username != null) {	  
	    	UserObject user = userDao.getUserByTendangnhap(username);
	    	HocSinhObject hocSinh = hsDao.getHocSinhByTDN(username);
	    	List<HS_KQHT_Object> list_KQHT = kqhtDao.getKqhtByHocSinhId(hocSinh.getHocsinh_id(), lop, ki);
	        model.addAttribute("user", user);
	        model.addAttribute("hocsinh", hocSinh);
	        model.addAttribute("list_lop", getList(5));
	        model.addAttribute("list_ki", getList(2));
	        model.addAttribute("lop", lop);
	    	model.addAttribute("list_KQHT", list_KQHT);
	    	
	        
	        return "hocsinh_ketquahoctap";
	    } else {
	        return "redirect:/login";
	    }
	}
	
	private Set<Integer> getList(int n) {
		Set<Integer> set = new TreeSet<>();
		for(int i =1; i<=n; i++) {
			set.add(i);
		}
		return set;
	}
}
