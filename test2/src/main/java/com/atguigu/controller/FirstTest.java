package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 李晓扬
 * @version 1.0
 * @description: 使用视图解析器，createView（），创建一个JstlView方便国际化
 * @date 2021/7/12 22:35
 */
@Controller
public class FirstTest {
    @RequestMapping(value = "/handle1")
    public String handle(){
        return "success";
    }
}
