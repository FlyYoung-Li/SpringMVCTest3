package com.mybatis.mapper;

import com.mybatis.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 李晓扬
 * @version 1.0
 * @description: TODO
 * @date 2021/8/6 17:37
 */
public interface TeacherMapper {

    public Teacher getTeacherById( Integer id);
}
