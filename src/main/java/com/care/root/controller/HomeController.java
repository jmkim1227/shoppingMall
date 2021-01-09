package com.care.root.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.goodsservice.GoodsService;
import com.care.root.goodsvo.GoodsVO;
import com.care.root.shopservice.ShopService;

@Controller
public class HomeController {
	@Autowired
	private GoodsService goodsService;
	@Autowired ShopService shopService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<GoodsVO> list = goodsService.goodsList();
		model.addAttribute("list",list);
		return "default/index";
	}
	@RequestMapping("default/test")
	public String test() {
		return "default/test";
	}
	
	@RequestMapping("default/goodsList")
	public String list(@RequestParam("category") String category,Model model) {
		List<GoodsVO> list = null;
		list = shopService.list(category);
		model.addAttribute("list",list);
		return "default/goodsList";
	}
	
	
	@RequestMapping("default/totalList")
	public String totalList(Model model) {
		List<GoodsVO> list = goodsService.goodsList();
		model.addAttribute("list",list);
		return "default/goodsList";
	}
}
