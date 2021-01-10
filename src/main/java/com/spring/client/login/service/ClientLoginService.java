package com.spring.client.login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.spring.common.member.MemberVO;



public interface ClientLoginService {
    public MemberVO user_check(MemberVO memberVO) throws Exception;
    public void clientLogout(HttpSession session) throws Exception;
}