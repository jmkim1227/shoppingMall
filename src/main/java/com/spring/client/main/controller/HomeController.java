package com.spring.client.main.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.client.goods.service.ClientGoodsService;
import com.spring.client.goods.vo.ClientGoodsVO;

@Controller
public class HomeController {
	@Autowired
	private ClientGoodsService clientGoodsService;
	
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String index(Model model) {
		List<ClientGoodsVO> list = clientGoodsService.getNewGoodsListToMain();
		model.addAttribute("list",list);
		return "default/index";
	}
	
	@RequestMapping(value = "/index.do", method = RequestMethod.POST)
	public String index2(Model model) {
		List<ClientGoodsVO> list = clientGoodsService.getNewGoodsListToMain();
		model.addAttribute("list",list);
		return "default/index";
	}
	
	@RequestMapping("goods/casual.do")
	public String casual() {
		return "goods/casual";
	}
	@RequestMapping("goods/woman.do")
	public String woman() {
		return "goods/woman";
	}
	@RequestMapping("goods/comfort.do")
	public String comfort() {
		return "goods/comfort";
	}
	@RequestMapping("goods/sandal.do")
	public String sandal() {
		return "goods/sandal";
	}
	
}
