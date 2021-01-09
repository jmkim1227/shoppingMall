package com.care.root.shopservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.cartlistvo.CartListVO;
import com.care.root.cartvo.CartVO;
import com.care.root.goodsvo.GoodsVO;
import com.care.root.orderListVO.OrderListVO;
import com.care.root.orderdetailvo.OrderDetailVO;
import com.care.root.ordervo.OrderVO;
import com.care.root.shopdao.ShopDAO;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired private ShopDAO shopDAO;
	@Override
	//상품 상세정보
	public GoodsVO goodsView(int goodsNum) {
		return shopDAO.goodsView(goodsNum);
	}
	//카테고리별 목록
	public List<GoodsVO> list(String category){
		return shopDAO.list(category);
	}
	//카트 담기
	public void addCart(CartVO cartVO) {
		shopDAO.addCart(cartVO);
		System.out.println("serviceVO:"+cartVO.toString());
	}
	//카트 목록
	public List<CartListVO> cartList(String id){
		return shopDAO.cartList(id);
	}
	//카트 삭제
	public void deleteCart(CartVO cartVO) {
		shopDAO.deleteCart(cartVO);
	}
	//주문 정보
	public void orderInfo(OrderVO orderVO) {
		shopDAO.orderInfo(orderVO);
	}
	//주문 상세 정보
	public void orderInfo_Details(OrderDetailVO orderDetailVO) {
		shopDAO.orderInfo_Details(orderDetailVO);
	}
	//카트 비우기
	public void deleteAllCart(String id) {
		shopDAO.deleteAllCart(id);
	}
	//주문 목록
	public List<OrderVO> orderList(OrderVO orderVO){
		return shopDAO.orderList(orderVO);
	}
	//특정 주문 목록
	public List<OrderListVO> orderView(OrderVO orderVO){
		return shopDAO.orderView(orderVO);
	}
}
