package com.mbg;

import com.mbg.entity.Cat;
import com.mbg.mapper.CatMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author 李晓扬
 * @version 1.0
 * @description: TODO
 * @date 2021/8/7 15:39
 */
public class MBGTest {
    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //java方式，要配置mbg.xml
        File configFile = new File("F:\\JavaSpace\\SpringMVCTest3\\MyBatis-Generator\\src\\main\\resources\\generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
//    因为原来，是自己定义的mapper（现在使用逆向工程自动生成），插入500条数据，而且是从页面发请求过来，进行添加的
   /* @Test
    public void test01() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CatMapper mapper = sqlSession.getMapper(CatMapper.class);
        List<Cat> cats = new ArrayList<Cat>();
        for (int i = 0; i < 500; i++) {
            cats.add(new Cat(null, UUID.randomUUID().toString().substring(0,5),"北京","A"));
        }
        mapper.insertCats(cats);
        sqlSession.close();
    }*/
}
