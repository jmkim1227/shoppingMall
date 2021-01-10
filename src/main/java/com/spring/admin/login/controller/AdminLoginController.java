package com.spring.admin.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.admin.login.service.AdminLoginService;

@Controller
@RequestMapping("admin")
public class AdminLoginController {
	@Autowired private AdminLoginService adminService;
	
	//관리자 체크
		@PostMapping("/admin_check.do")
		public String admin_check(HttpServletRequest request,Model model) {
			System.out.println(adminService.admin_check(request, model));
			if(adminService.admin_check(request, model)==1) {
				System.out.println("test");
				return "admin/index";
			}else {
				System.out.println("test222");
				return "redirect:/admin/adminlogin.do";
			}
		}
		//관리자 로그인
		@RequestMapping("/adminlogin.do")
		public String login() {
			return "admin/adminlogin";
		}
		
		//관리자 로그아웃
		@RequestMapping("/adminlogout.do")
		public String logout(HttpSession session) {
			System.out.println(session.getAttribute("adminid"));
			if(session.getAttribute("adminid") != null) {
				session.invalidate();	
			}
			return "redirect:/index.do";
		}
}
