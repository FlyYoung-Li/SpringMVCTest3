package com.web.dao;

import com.web.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author 李晓扬
 * @version 1.0
 * @description: TODO
 * @date 2021/8/1 22:59
 */

public interface TeacherDao {
    public List<Teacher> getTeachers();
    public Teacher getTeacherById(Integer id);
    public Integer updateTeacher(Teacher teacher);
    public Integer insertTeacher(Teacher teacher);
    public Integer deleteTeacherById(Integer id);
}
