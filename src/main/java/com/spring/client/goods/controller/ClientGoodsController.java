package com.spring.client.goods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.client.goods.service.ClientGoodsService;
import com.spring.client.goods.vo.ClientGoodsVO;


@Controller
public class ClientGoodsController {
	@Autowired 
	private ClientGoodsService clientGoodsService;
	//	@Autowired private ShopDAO shopDAO;
	//	@Override
	//	//상품 상세정보
	//	public GoodsVO goodsView(int goodsNum) {
	//		return shopDAO.goodsView(goodsNum);
	//	}
	//	//카테고리별 목록
	//	public List<GoodsVO> list(String category){
	//		return shopDAO.list(category);
	//	}
	
	//선택 상품 조회
	@RequestMapping("goods/shop.do")
	public String view(@RequestParam("n") int goodsNum,Model model ) {
		ClientGoodsVO view = clientGoodsService.goodsView(goodsNum);
		model.addAttribute("view",view);
		return "goods/shop";
	}

	@RequestMapping("default/goodsList.do")
	public String list(@RequestParam("category") String category,Model model) {
		List<ClientGoodsVO> list = null;
		list = clientGoodsService.list(category);
		model.addAttribute("goodsList",list);
		model.addAttribute("category", category);
		return "goods/goodsList";
	}


	@RequestMapping("default/totalList.do")
	public String totalList(Model model) {
		List<ClientGoodsVO> list = clientGoodsService.goodsList();
		model.addAttribute("goodsList",list);
		model.addAttribute("category", "ALL");
		return "goods/goodsList";
	}
	
}
