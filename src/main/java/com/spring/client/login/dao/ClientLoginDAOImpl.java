package com.spring.client.login.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.common.member.MemberVO;


@Repository
public class ClientLoginDAOImpl implements ClientLoginDAO{
    static String namespace = "com.care.mybatis.myMapper";
    @Autowired
    SqlSessionTemplate sqlSession;
    public MemberVO user_check(MemberVO memberVO) throws Exception{
        return sqlSession.selectOne(namespace+".user_check", memberVO);
    }

}
