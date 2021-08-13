package com.web;


import com.web.dao.TeacherDao;
import com.web.dao.TeacherDaoAnnotation;
import com.web.entity.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;


class TeacherDaoTestTest {
    private  SqlSession sqlSession;
    //使用class注册，并使用注解，没写sql映射文件的测试
    @Test
    public void test05(){
        TeacherDaoAnnotation mapper = sqlSession.getMapper(TeacherDaoAnnotation.class);
        Teacher teacherById = mapper.getTeacherById(5);
        System.out.println(teacherById);
        sqlSession.close();
    }
//    select的测试
    @Test
    public void test01() throws IOException {
        //获取映射器(代理对象)
        try {
            TeacherDao mapper = sqlSession.getMapper(TeacherDao.class);
            Teacher teacherById = mapper.getTeacherById(4);
            System.out.println(teacherById);
        } finally {
            sqlSession.close();
        }
    }
//    这是一个初始化方法,所有的方法,都要执行这一个,并且去获取sqlSession这一个连接
//junit5之后,原来的Before变成了BeforeEach
    @BeforeEach
    public void init() throws IOException {
        //获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取连接sqlSession
        sqlSession = sqlSessionFactory.openSession();
    }
    //    update的测试
    @Test
    public void test02() throws IOException {
        //获取映射器(代理对象)
        try {
            TeacherDao mapper = sqlSession.getMapper(TeacherDao.class);
            Integer integer = mapper.updateTeacher(new Teacher(1, "我是大", 54, "加拿大"));
            System.out.println("修改成功,"+integer+"几行收了影响");
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    } //    insert的测试
    @Test
    public void test03() throws IOException {
        //获取映射器(代理对象)
        try {
            TeacherDao mapper = sqlSession.getMapper(TeacherDao.class);
            Teacher teacher = new Teacher(null, "放大发", 77, "地中海");
            Integer integer = mapper.insertTeacher(teacher);
            System.out.println("插入成功,"+integer+"几行收了影响");
            System.out.println("看看能否获取到主键："+teacher.getId());
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    } //    delete的测试
    @Test
    public void test04() throws IOException {
        //获取映射器(代理对象)
        try {
            TeacherDao mapper = sqlSession.getMapper(TeacherDao.class);
            Integer integer = mapper.deleteTeacherById(6);
            System.out.println("删除成功,"+integer+"几行收了影响");
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }//测试返回List
    @Test
    public void test06() throws IOException {
        //获取映射器(代理对象)
        try {
            TeacherDao mapper = sqlSession.getMapper(TeacherDao.class);
            List<Teacher> teachers = mapper.getTeachers();
            for (Teacher teacher:teachers) {
                System.out.println(teacher);
                System.out.println("hhh");
            }
//            sqlSession.commit();,commit不影响
        } finally {
            sqlSession.close();
        }
    }
}
