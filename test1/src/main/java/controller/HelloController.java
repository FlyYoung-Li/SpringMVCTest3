package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;

import javax.tools.ForwardingFileObject;
import java.nio.channels.FileChannel;
import java.util.Map;

/**
 * @author 李晓扬
 * @version 1.0
 * @description: TODO
 * @date 2021/7/1 11:56
 */

@Controller
public class HelloController {
    private Object o1;
    private Object o2;
    private Object u1;
    private Object u2;
    @RequestMapping("/handle")
    public String handle1(@RequestParam("username") String username , Map<String,String> map){
        map.put("username", username);
        System.out.println("访问get成功"+username);
        return "success";
    }
    @RequestMapping(value = "/handle",method = RequestMethod.POST)
    public String handle2(  User user,Map<String,Object> map){
        u2 = user;
        o2 = map;
        System.out.println("现在隐含模型中有User对象，看看不会会使用");
        System.out.println(user);
        System.out.println("访问post成功，并且使用ModleAndView成功"+user);
        System.out.println(u1==u2);
        System.out.println(o1==o2);
       return "success";

    }
    @RequestMapping(value = "/handle",method = RequestMethod.PUT)
    public String handle3(@RequestParam(value = "name",required = false,defaultValue = "我是默认值")String name){
        System.out.println("访问put成功"+name);
        return "success";
    }
    @RequestMapping(value = "/handle",method = RequestMethod.DELETE)
    public String handle4(
            @RequestHeader("User-Agent")String user,
           @CookieValue("JSESSIONID")String id)
    {
        System.out.println("\n访问delete成功\t"+user+id);
        return "success";
    }
    @RequestMapping("/forward")
    public String handle4(){
        System.out.println("forward:转发，由自己控制页面");
        return "forward:/WEB-INF/page/success.jsp";
    }
    //这是可以运行的，使用Model
//    @ModelAttribute()
//    public void getUser(Model model){
//        System.out.println("现在使用的User对象，是从数据库中获取到的");
//        User lxy = new User("lxy", null, null, null);
//        System.out.println(lxy);
//        //注意隐含模型，同时注意类型，model表示直接存入的类型，而Map则是双列集合
//        model.addAttribute(lxy);
//    }
    @ModelAttribute()
    public User getUser(Map<String,Object> model){

        System.out.println("现在使用的User对象，是从数据库中获取到的");
        User lxy = new User("lxy", 23, "男", null);
        System.out.println(lxy);
        u1 = lxy;
        //注意map中存入隐含模型中的数据，有一个key可以指定
//        model.put("user",lxy);
        o1 = model;
        return lxy;
    }
    @RequestMapping("/handle5")
    public ModelAndView handle5(){
        ModelAndView mv = new ModelAndView("success");
        mv.addObject("msg", "你好啊");
        return  mv;
    }
}
