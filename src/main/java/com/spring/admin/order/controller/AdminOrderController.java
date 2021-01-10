package com.spring.admin.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.admin.goods.vo.AdminGoodsVO;
import com.spring.admin.order.service.AdminOrderService;
import com.spring.admin.order.vo.AdminOrderDetailVO;
import com.spring.admin.order.vo.AdminOrderVO;

@Controller
@RequestMapping("admin")
public class AdminOrderController {
	
	@Autowired
	private AdminOrderService adminOrderService;
	
	// 주문 목록
	@RequestMapping("orderList.do")
	public void getOrderList(AdminOrderVO adminOrderVO, Model model) throws Exception {

		List<AdminOrderVO> orderList = adminOrderService.orderList(adminOrderVO);

		model.addAttribute("orderList", orderList);
	}

	// 주문 상세 목록
	@RequestMapping("orderView.do")
	public void getOrderList(@RequestParam("n") String orderId,
			AdminOrderVO adminOrderVO, Model model) throws Exception {

		adminOrderVO.setOrderId(orderId);  
		List<AdminOrderVO> orderView = adminOrderService.orderView(adminOrderVO);

		model.addAttribute("orderView", orderView);
	}

	// 주문 상세 목록 - 상태 변경
	@RequestMapping(value = "/orderView.do", method = RequestMethod.POST)
	public String delivery(AdminOrderVO adminOrderVO) throws Exception {

		adminOrderService.delivery(adminOrderVO);
		System.out.println("주문상세목록 테스트");

		//상품 수량 조절
		List<AdminOrderVO> orderView = adminOrderService.orderView(adminOrderVO); 

		AdminGoodsVO adminGoodsVO = new AdminGoodsVO();

		for(AdminOrderVO i : orderView) {
			adminGoodsVO.setGoodsNum(i.getGoodsNum());
			adminGoodsVO.setGoodsStock(i.getCartStock());
			adminOrderService.changeStock(adminGoodsVO);
		}

		return "redirect:/admin/orderView.do?n=" + adminOrderVO.getOrderId();
	}

}
