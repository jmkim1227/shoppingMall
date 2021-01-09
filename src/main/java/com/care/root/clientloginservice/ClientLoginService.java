package com.care.root.clientloginservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.care.root.clientloginvo.ClientLoginVO;
import com.care.root.membervo.MemberVO;



public interface ClientLoginService {
    public MemberVO user_check(MemberVO memberVO) throws Exception;
    public void clientLogout(HttpSession session) throws Exception;
}