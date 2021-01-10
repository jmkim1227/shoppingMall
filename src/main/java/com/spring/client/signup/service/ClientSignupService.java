package com.spring.client.signup.service;

import org.springframework.ui.Model;

import com.spring.common.member.MemberVO;

public interface ClientSignupService {
	   public void signup(MemberVO memberVO);
	   public int checkId(MemberVO memberVO);
	   public void memberInfo(Model model);
	   public void memberDelete(int bno);
	}