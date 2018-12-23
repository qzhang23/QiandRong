package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@Controller
public class adminloginController {
	UserRepository userp;
	@RequestMapping(value="admin-login", method=RequestMethod.POST)
	public String adminlogin(HttpServletRequest request) {
		String username=(String)request.getParameter("name");
		String password=(String)request.getParameter("password");
		if(username.equals("admin")) {
			User admin = userp.findByUsername("admin");
			if(password.equals(admin.getPassword())) {
				HttpSession session = request.getSession(true);
				session.setAttribute("username", username);
				//return "";
			}
			
			//session.setAttribute(, value);
			return "redirect:/admin_index";
		}
		else {
			return "wrong user(admin)";
		}
		//return null;
		
	}

}
