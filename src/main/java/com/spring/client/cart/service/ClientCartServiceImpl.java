package com.spring.client.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.client.cart.dao.CartDAO;

import com.spring.client.cart.vo.CartListVO;
import com.spring.client.cart.vo.CartVO;

@Service
public class ClientCartServiceImpl implements ClientCartService {

	@Autowired private CartDAO CartDAO;
	//카트 담기
	public void addCart(CartVO cartVO) {
		CartDAO.addCart(cartVO);
		System.out.println("serviceVO:"+cartVO.toString());
	}
	//카트 목록
	public List<CartListVO> cartList(String id){
		return CartDAO.cartList(id);
	}
	//카트 삭제
	public void deleteCart(CartVO cartVO) {
		CartDAO.deleteCart(cartVO);
	}

	//카트 비우기
	public void deleteAllCart(String id) {
		CartDAO.deleteAllCart(id);
	}

}
