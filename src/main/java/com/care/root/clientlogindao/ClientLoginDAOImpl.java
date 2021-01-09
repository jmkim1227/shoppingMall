package com.care.root.clientlogindao;


import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.care.root.clientloginvo.ClientLoginVO;
import com.care.root.membervo.MemberVO;

@Repository
public class ClientLoginDAOImpl implements ClientLoginDAO{
    static String namespace = "com.care.mybatis.myMapper";
    @Autowired
    SqlSession sqlSession;
    public MemberVO user_check(MemberVO memberVO) throws Exception{
        return sqlSession.selectOne(namespace+".user_check", memberVO);
    }

}
