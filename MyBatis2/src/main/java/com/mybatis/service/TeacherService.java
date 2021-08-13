package com.mybatis.service;

import com.mybatis.entity.Teacher;
import com.mybatis.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 李晓扬
 * @version 1.0
 * @description: TODO
 * @date 2021/8/6 17:45
 */
@Service
public class TeacherService {
    @Autowired(required = false)
    TeacherMapper teacherMapper;
    @Transactional
    public void getTeacherById(Integer id){
        Teacher teacherById = teacherMapper.getTeacherById(id);
        System.out.println(teacherById);
        System.out.println(id+"验证一下，service是否可以注入");
    }
}
