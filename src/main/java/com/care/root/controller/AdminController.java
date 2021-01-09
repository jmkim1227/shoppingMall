package com.care.root.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.root.adminservice.AdminService;
import com.care.root.goodsservice.GoodsService;
import com.care.root.goodsvo.GoodsVO;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired private GoodsService goodsService;
	@Autowired private AdminService adminService;

	//관리자 체크
	@PostMapping("admin_check")
	public String admin_check(HttpServletRequest request,Model model) {
		System.out.println(adminService.admin_check(request, model));
		if(adminService.admin_check(request, model)==1) {
			System.out.println("test");
			return "redirect:/admin/index";
		}else {
			System.out.println("test222");
			return "redirect:/admin/adminlogin";
		}
	}
	
	//관리자 로그인
	@RequestMapping("adminlogin")
	public String login() {
		return "admin/adminlogin";
	}
	//관리자 로그아웃
	@RequestMapping("adminlogout")
	public String logout(HttpSession session) {
		System.out.println(session.getAttribute("adminid"));
		if(session.getAttribute("adminid") != null) {
			session.invalidate();	
		}
		return "redirect:/";
	}
	@RequestMapping("index")
	public String adminIndex(Model model) {
		List<GoodsVO> list = goodsService.goodsList();
		model.addAttribute("list",list);
		return "admin/index";
	}

}















