package com.duwan.hocba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
//    private final UserInterface userInterface;
//
//    public LoginController(UserInterface userInterface) {
//        this.userInterface = userInterface;
//    }

    @GetMapping("/login") 
    public String showLoginForm() {
        return "login";
    }      
//    @PostMapping("login")
//    public String processLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
//        List<UserObject> users = userInterface.fetchAllUser();
//        if (users != null && !users.isEmpty()) {
//            for (UserObject user : users) {
//                if (username.equals(user.getTendangnhap()) && password.equals(user.getPassword())) {
//                	session.setAttribute("login_username", user.getTendangnhap());
//                    return "redirect:/userinfor";
//                }
//            }
//        }
//        return "login";
//    }
}
