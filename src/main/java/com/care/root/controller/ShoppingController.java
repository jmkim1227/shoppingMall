package com.care.root.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("shopping")
public class ShoppingController {
	@RequestMapping("potoreview")
	public String potoreview() {
		return "shopping/potoreview";
	}
	@RequestMapping("search")
	public String search() {
		return "shopping/search";
	}
}
