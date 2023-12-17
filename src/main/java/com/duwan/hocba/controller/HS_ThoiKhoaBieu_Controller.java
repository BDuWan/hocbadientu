package com.duwan.hocba.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.duwan.hocba.interfac.HS_TKB_Interface;
import com.duwan.hocba.interfac.HocSinhInterface;
import com.duwan.hocba.interfac.UserInterface;
import com.duwan.hocba.object.HS_TKB_Object;
import com.duwan.hocba.object.HocSinhObject;
import com.duwan.hocba.object.UserObject;

import jakarta.servlet.http.HttpSession;

@Controller
public class HS_ThoiKhoaBieu_Controller {
	private final UserInterface userInterface;
	private final HS_TKB_Interface hs_TKB_Interface;
	private final HocSinhInterface hocSinhInterface;
	
	public HS_ThoiKhoaBieu_Controller(UserInterface userInterface,
			HS_TKB_Interface hs_TKB_Interface, HocSinhInterface hocSinhInterface) {
		this.userInterface = userInterface;
		this.hs_TKB_Interface = hs_TKB_Interface;
		this.hocSinhInterface = hocSinhInterface;
	}
	
	@GetMapping("/hocsinh/thoikhoabieu")
	public String showHS_TKBPage(HttpSession session, Model model) {
	    String username = (String) session.getAttribute("current_username");
	    if (username != null) {	    	
	    	UserObject user = userInterface.getUserByTendangnhap(username);
	        model.addAttribute("user", user);
	        
	        HocSinhObject hocsinh = hocSinhInterface.getHocSinhByTDN(username);
	        session.setAttribute("current_hocsinh", hocsinh);
	        
	        List<HS_TKB_Object> list_tkb = hs_TKB_Interface.getTKBbyhocsinhId(hocsinh.getHocsinh_id());
	        List<HS_TKB_Object> tkb_thu2 = new ArrayList<>();
	        List<HS_TKB_Object> tkb_thu3 = new ArrayList<>();
	        List<HS_TKB_Object> tkb_thu4 = new ArrayList<>();
	        List<HS_TKB_Object> tkb_thu5 = new ArrayList<>();
	        List<HS_TKB_Object> tkb_thu6 = new ArrayList<>();
	        List<HS_TKB_Object> tkb_thu7 = new ArrayList<>();

	        for (HS_TKB_Object tkb : list_tkb) {
				if(tkb.getThoigian() == 2) {
					tkb_thu2.add(tkb);
				}
				if(tkb.getThoigian() == 3) {
					tkb_thu3.add(tkb);
				}
				if(tkb.getThoigian() == 4) {
					tkb_thu4.add(tkb);
				}
				if(tkb.getThoigian() == 5) {
					tkb_thu5.add(tkb);
				}
				if(tkb.getThoigian() == 6) {
					tkb_thu6.add(tkb);
				}
				if(tkb.getThoigian() == 7) {
					tkb_thu7.add(tkb);
				}
			}
	        XulyData("tkb_thu2", tkb_thu2, model);
	        XulyData("tkb_thu3", tkb_thu3, model);
	        XulyData("tkb_thu4", tkb_thu4, model);
	        XulyData("tkb_thu5", tkb_thu5, model);
	        XulyData("tkb_thu6", tkb_thu6, model);
	        XulyData("tkb_thu7", tkb_thu7, model);
	        return "hocsinh_thoikhoabieu";
	    } else {
	        return "redirect:/login";
	    }
	}
	
	private void XulyData(String tkb, List<HS_TKB_Object> tkb_thu, Model model) {
		for(int i=0;i<7;i++) {
        	if(i < tkb_thu.size()) {
	        	if(tkb_thu.get(i).getTiethoc() > i+1) {
	        		HS_TKB_Object x = new HS_TKB_Object("X");
	        		tkb_thu.add(i, x);
	        	}
        	}
        	else {
        		HS_TKB_Object x = new HS_TKB_Object("X");
        		tkb_thu.add(i, x);
			}	        	
        }
        
        HS_TKB_Object x = new HS_TKB_Object("***********************");
		tkb_thu.add(4, x);
		
        model.addAttribute(tkb, tkb_thu);
	}
}
