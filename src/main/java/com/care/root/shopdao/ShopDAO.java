package com.care.root.shopdao;

import java.util.List;

import com.care.root.cartlistvo.CartListVO;
import com.care.root.cartvo.CartVO;
import com.care.root.goodsvo.GoodsVO;
import com.care.root.orderListVO.OrderListVO;
import com.care.root.orderdetailvo.OrderDetailVO;
import com.care.root.ordervo.OrderVO;

public interface ShopDAO {
	//상품 조회
	public GoodsVO goodsView(int goodsNum);
	//카테고리별 상품조회
	public List<GoodsVO> list(String category);
	//카트 담기
	public void addCart(CartVO cartVO); 
	//카트 리스트
	public List<CartListVO> cartList(String id);
	//카트 삭제
	public void deleteCart(CartVO cartVO);
	//주문 정보
	public void orderInfo(OrderVO orderVO);
	//주문 상세 정보
	public void orderInfo_Details(OrderDetailVO orderDetailVO);
	//카트 비우기
	public void deleteAllCart(String id);
	//주문 목록
	public List<OrderVO> orderList(OrderVO orderVO);
	//특정 주문 목록
	public List<OrderListVO> orderView(OrderVO orderVO);
}
