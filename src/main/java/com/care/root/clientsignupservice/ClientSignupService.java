package com.care.root.clientsignupservice;

import com.care.root.membervo.MemberVO;

public interface ClientSignupService {
	   public void signup(MemberVO memberVO);

	   public int checkId(MemberVO memberVO);
	}