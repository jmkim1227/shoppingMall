package com.spring.client.cart.service;

import java.util.List;

import com.spring.client.cart.vo.CartListVO;
import com.spring.client.cart.vo.CartVO;

public interface ClientCartService {
	//카트 담기
	public void addCart(CartVO cartVO);
	//카트 리스트
	public List<CartListVO> cartList(String id);
	//카트 삭제
	public void deleteCart(CartVO cartVO);
	//카트 비우기
	public void deleteAllCart(String id);
}
