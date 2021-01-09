package com.care.root.clientloginservice;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.clientlogindao.ClientLoginDAO;
import com.care.root.clientloginvo.ClientLoginVO;
import com.care.root.membervo.MemberVO;

@Service
public class ClientLoginServiceImpl implements ClientLoginService{
    @Autowired
    ClientLoginDAO clientLoginDAO;
    @Override
    public MemberVO user_check(MemberVO memberVO) throws Exception{
        return clientLoginDAO.user_check(memberVO);
    }
    @Override
    public void clientLogout(HttpSession session) throws Exception {
        session.invalidate();
    }

}