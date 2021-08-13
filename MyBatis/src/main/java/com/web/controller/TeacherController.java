package com.web.controller;

import com.web.entity.Teacher;
import com.web.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 李晓扬
 * @version 1.0
 * @description: TODO
 * @date 2021/8/1 23:20
 */
@Controller
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "getTeacherById",method = RequestMethod.GET)
    public String getTeacherById(@RequestParam(value = "id",required = false,defaultValue ="1") Integer id){
        Teacher teacherByID = teacherService.getTeacherByID(id);
        return "success1";
    }

}
