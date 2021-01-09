package com.care.root.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.care.root.cartlistvo.CartListVO;
import com.care.root.cartvo.CartVO;
import com.care.root.goodsvo.GoodsVO;
import com.care.root.membervo.MemberVO;
import com.care.root.shopservice.ShopService;

@Controller
@RequestMapping("goods")
public class ShopController {
	@Autowired ShopService shopService;
	@RequestMapping("casual")
	public String casual() {
		return "goods/casual";
	}
	@RequestMapping("woman")
	public String woman() {
		return "goods/woman";
	}
	@RequestMapping("comfort")
	public String comfort() {
		return "goods/comfort";
	}
	@RequestMapping("sandal")
	public String sandal() {
		return "goods/sandal";
	}

	
	//상품 조회
	@RequestMapping("shop")
	public String view(@RequestParam("n") int goodsNum,Model model ) {
		GoodsVO view = shopService.goodsView(goodsNum);
		model.addAttribute("view",view);
		return "goods/shop";
	}
	

	
}
