package com.mbg.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mbg.entity.Cat;
import com.mbg.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 李晓扬
 * @version 1.0
 * @description: TODO
 * @date 2021/8/7 20:53
 */
@Controller
public class CatController {
    @Autowired(required = false)
    CatService catService;
    //  这里，两个方法，报错很正常  因为原来，是自己定义的mapper，插入500条数据，而且是从页面发请求过来，进行添加的
    /*@RequestMapping("/insert500")
    public String insert500(){
        catService.insert500();
        return "success";
    }*/

  /*  @RequestMapping("/getCats")
    public String getCats(@RequestParam(value = "pageId",defaultValue = "1")Integer page, ModelMap model){
        //显示的当前页码，和记录数（导航数是自己算出来的）
        PageHelper.startPage(page,5);
        List<Cat> cats = catService.getCats();
        PageInfo<Cat> pageInfo = new PageInfo<Cat>(cats);
//        model.addAttribute("cats",cats);不用存两个，
//        Model中存一个pageIofo，就可以（pageInfo包装了List，自然可以直接取）
        model.addAttribute("pageHelp",pageInfo);
        return "list";
    }*/
}
