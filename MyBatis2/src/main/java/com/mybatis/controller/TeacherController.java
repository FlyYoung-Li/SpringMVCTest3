package com.mybatis.controller;

import com.mybatis.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 李晓扬
 * @version 1.0
 * @description: TODO
 * @date 2021/8/6 17:43
 */
@Controller
public class TeacherController {
    @Autowired(required = false)
     TeacherService teacherService;
    @RequestMapping("/getTeacherById")
    public String getTeacherById(@RequestParam(value = "id",required = false,defaultValue ="1") Integer id){
        teacherService.getTeacherById(id);
        return "success";
    }
}
