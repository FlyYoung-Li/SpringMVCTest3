package com.mbg.mapper;

import com.mbg.entity.Cat;
import com.mbg.entity.CatExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 李晓扬
 * @version 1.0
 * @description: TODO
 * @date 2021/8/12 7:50
 */
class CatMapperTest {

    SqlSession sqlSession;

    @Test
    public void test01() {
        //在使用复杂的逆向工程创建了entity、mapper和sql映射文件时，还会创建entityExample对象（有criteria标准）
        CatMapper mapper = sqlSession.getMapper(CatMapper.class);
        //得到Example设置查询条件
        try {
            CatExample catExample = new CatExample();
            CatExample.Criteria criteria = catExample.createCriteria();
            criteria.andNameLike("%e%");
            List<Cat> cats = mapper.selectByExample(catExample);
            for (Cat cat : cats) {
                System.out.println(cat);
            }
        } finally {
            sqlSession.close();
        }
    }

    @BeforeEach
    public void init() throws IOException {
        //获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取连接sqlSession
        sqlSession = sqlSessionFactory.openSession();
    }
}