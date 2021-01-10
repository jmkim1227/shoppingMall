package com.spring.client.login.dao;

import com.spring.common.member.MemberVO;

public interface ClientLoginDAO {
	public MemberVO user_check(MemberVO memberVO) throws Exception;
}
