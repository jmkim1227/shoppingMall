package com.spring.admin.main.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.admin.goods.service.AdminGoodsService;
import com.spring.admin.goods.vo.AdminGoodsVO;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired 
	private AdminGoodsService adminGoodsService;
	
	@RequestMapping("index.do")
	public String adminIndex(Model model) {
		List<AdminGoodsVO> list = adminGoodsService.goodsList();
		model.addAttribute("list",list);
		return "admin/index";
	}
}















