package com.spring.client.signup.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.ui.Model;

import com.spring.common.member.MemberVO;

public interface ClientSignupDAO {
	   public void signup(MemberVO memberVO);
	   public int checkId(MemberVO memberVO);
	   public List<MemberVO> memberInfo();
	   public void memberDelete(int bno);
	}