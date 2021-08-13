package com.web.service;

import com.web.dao.TeacherDao;
import com.web.entity.Teacher;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 李晓扬
 * @version 1.0
 * @description: TODO
 * @date 2021/8/1 23:18
 */
/*@Transactional*/
@Service
public class TeacherService {
     @Autowired
     TeacherDao teacherDao;
    /*@Qualifier
    TeacherDao teacherDao;*/

    public Teacher getTeacherByID(Integer id) {
        Teacher teacherById = teacherDao.getTeacherById(id);
        System.out.println("执行成功");
        return teacherById;
    }
}
