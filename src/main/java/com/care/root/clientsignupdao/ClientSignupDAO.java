package com.care.root.clientsignupdao;

import com.care.root.membervo.MemberVO;

public interface ClientSignupDAO {
	   public void signup(MemberVO memberVO);
	   public int checkId(MemberVO memberVO);

	}