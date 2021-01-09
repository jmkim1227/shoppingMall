package com.care.root.adminservice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.care.root.goodsvo.GoodsVO;
import com.care.root.orderListVO.OrderListVO;
import com.care.root.ordervo.OrderVO;



public interface AdminService {
	public int admin_check(HttpServletRequest request, Model model);
	//주문 목록
	public List<OrderVO> orderList();
	//특정 주문 목록
	public List<OrderListVO> orderView(OrderVO orderVO);
	//배송 상태
	public void delivery(OrderVO orderVO);
	//상품 수량 조절
	public void changeStock(GoodsVO goodsVO);
}
