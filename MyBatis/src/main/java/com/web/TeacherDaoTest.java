package com.web;

import com.web.dao.TeacherDao;
import com.web.entity.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;

/**
 * @author 李晓扬
 * @version 1.0
 * @description: TODO
 * @date 2021/8/2 14:24
 */
public class TeacherDaoTest {
    public static void main(String[] args) throws IOException {
        //获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取连接sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取映射器(代理对象)
        try {
            TeacherDao mapper = sqlSession.getMapper(TeacherDao.class);
            Teacher teacherById = mapper.getTeacherById(2);
            System.out.println(teacherById);
        } finally {
            sqlSession.close();
        }
    }



}
