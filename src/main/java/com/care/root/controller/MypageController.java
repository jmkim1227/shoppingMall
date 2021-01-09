package com.care.root.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mypage")
public class MypageController {
	@RequestMapping("mypage")
	public String mypage() {
		return "mypage/mypage";
	}
	@RequestMapping("myorder")
	public String myorder() {
		return "mypage/myorder";
	}
	@RequestMapping("myreserve")
	public String myreserve() {
		return "mypage/myreserve";
	}
	@RequestMapping("mywishlist")
	public String mywishlist() {
		return "mypage/mywishlist";
	}
	@RequestMapping("modify")
	public String modify() {
		return "mypage/modify";
	}
}
