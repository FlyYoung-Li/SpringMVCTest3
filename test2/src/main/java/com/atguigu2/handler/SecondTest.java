package com.atguigu2.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李晓扬
 * @version 1.0
 * @description: TODO
 * @date 2021/7/13 14:59
 */
@Controller
public class SecondTest {
    @RequestMapping("/handle2")
    public String handle2(Model model){
        List<String> videos = new ArrayList<>();
        List<String> images = new ArrayList<>();
        videos.add("lxy");
        videos.add("lxg");
        images.add("lxw");
        images.add("lxx");

        model.addAttribute("videos",videos);
        model.addAttribute("images",images);
        return "meinv:hello";
    }
}
