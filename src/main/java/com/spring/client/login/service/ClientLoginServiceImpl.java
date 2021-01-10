package com.spring.client.login.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.client.login.dao.ClientLoginDAO;
import com.spring.common.member.MemberVO;

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