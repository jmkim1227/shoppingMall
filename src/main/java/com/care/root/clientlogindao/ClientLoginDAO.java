package com.care.root.clientlogindao;

import com.care.root.clientloginvo.ClientLoginVO;
import com.care.root.membervo.MemberVO;

public interface ClientLoginDAO {
	public MemberVO user_check(MemberVO memberVO) throws Exception;
}
