package com.atguigu.handler;

import com.atguigu.entity.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author 李晓扬
 * @version 1.0
 * @description: TODO
 * @date 2021/7/24 12:14
 */
@Controller
public class MyEmployeeHandler {
    //    处理表单回显的方法（后端校验的方法）
    @RequestMapping(value = "/logging", method = RequestMethod.POST)
    private String logging(@Valid Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("有错误，检验不通过");
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println("什么字段" + fieldError.getField());
                System.out.println("错误信息" + fieldError.getDefaultMessage());
            }
            model.addAttribute("command", employee);
            return "submit";
        } else {
            System.out.println("登录成功");
            System.out.println(employee);
            return "success";
        }
    }

    //一登陆，返回输入页面
    @RequestMapping("/toSubmit")
    private String toSubmit(Model model) {
        Employee employee = new Employee();
        employee.setBirth(null);
        model.addAttribute("command", employee);
        return "submit";
    }

    //    处理springmvc支持ajax的方法
    @ResponseBody
    @RequestMapping(value = "/handleAjax", method = RequestMethod.POST)
    private Employee handleAjax(Employee employee) {
        System.out.println(employee);
        Employee employee1 = new Employee(5, "5", 5, "55", new Date());
        return employee1;
    }

    //    处理ajax表单回显的方法
    @ResponseBody
    @RequestMapping(value = "/getAEmployee", method = RequestMethod.GET)
    private Employee handleAjax02() {
        Employee employee = new Employee(10, "10", 10, "10", new Date());
        return employee;
    }

    //    处理requestBody接收请求体的方法
//这里说明了，执行完对应的请求后，是定要进行页面的跳转的，
// 默认拼串，/WEB-INF/page/requestBodyTest.jsp,所以报错
    @RequestMapping(value = "/requestBodyTest", method = RequestMethod.POST)
    private String handleAjax03(@RequestBody String requestBody) {
        System.out.println(requestBody);
        return "success";
    }

    //    处理requestBody注解接收json数据，并封装成对象的方法
    @RequestMapping(value = "/requestBodyTest2", method = RequestMethod.POST)
    private String handleAjax04(@RequestBody Employee employee) {
        System.out.println("这里就相当于ajax已经异步访问了一次，这个资源，" +
                "return false是为了阻止点击的那个标签，在执行完ajax异步请求后，不回来访问目标资源");
        System.out.println(employee);
        return "success";
    }

    //    使用HttpEntity<String>来接收请求体和请求头
    @RequestMapping(value = "/httpEntityTest", method = RequestMethod.POST)
    private String handleFileUpload(HttpEntity<String> b) {
        System.out.println(b);
        return "success";

    }

    //    处理文件下载(这里响应报文中，自己写的是包装类的Byte,实验证明错误，读需要的是byte[])
    @RequestMapping(value = "downloading", method = RequestMethod.GET)
    private ResponseEntity<byte[]> handleDownloading(HttpServletRequest request) throws IOException {
        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/page/wallhaven-272910 - 快捷方式.lnk");
        System.out.println(realPath);

//       文件输出流
        FileInputStream fileInputStream = new FileInputStream(realPath);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        System.out.println("到这里基本没有什么问题");
        fileInputStream.close();
//      设置响应对象
//        响应头的设置，记住文件下载：就是Content-Disposition，
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Disposition","attachment;filename="+"image.jpg");
        return new ResponseEntity<byte[]>(bytes,httpHeaders, HttpStatus.OK);
    }
//    处理文件上传的方法
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    private String fileUpload(@RequestParam("file") MultipartFile file)  {
        System.out.println("文件上传成功了");
        System.out.println("file.getName"+file.getName());
        System.out.println("file.getOriginalFilename"+file.getOriginalFilename());
        try {
            file.transferTo(new File("F://"+file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "forward:index.jsp";
    }


}
