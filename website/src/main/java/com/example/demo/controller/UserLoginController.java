package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@Controller
public class UserLoginController {
	UserRepository userp;
	
	@RequestMapping(value="logging",method=RequestMethod.POST)
	public String userlogin(HttpServletRequest request) {
		String username= (String)request.getParameter("name");
		String password = (String)request.getParameter("password");
		User user = userp.findByUsername(username);
		//return null;
		if(user!=null) {
			if(password.equals(user.getPassword())) {
				HttpSession session = request.getSession(true);
				session.setAttribute("username", username);
				session.setAttribute("vip", user.isVip());
				session.setAttribute("state", user.isState());
			}
			
		}
		return "redirect:/user_index";
	}

}
