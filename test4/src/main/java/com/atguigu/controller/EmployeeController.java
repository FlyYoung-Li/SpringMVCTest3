package com.atguigu.controller;

import com.atguigu.dao.DepartmentDao;
import com.atguigu.dao.EmployeeDao;
import com.atguigu.entities.Department;
import com.atguigu.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.beans.Encoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * @author 李晓扬
 * @version 1.0
 * @description: 使用视图解析器，createView（），创建一个JstlView方便国际化
 * @date 2021/7/12 22:35
 */
@Controller
public class EmployeeController {
    //属性注入
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping(value = "/handle3")
    public String handle() {
        return "success";
    }

    //进行页面的展示
    @RequestMapping(value = "/employees")
    public String getAll(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("employees", employees);
        return "show";
    }

    //跳转到add页面,才会显示要提交的表单，此时传command，进行页面回显
    @RequestMapping(value = "/toAdd")
    public String add(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("command", new Employee());
        model.addAttribute("departments", departments);
        return "add";
    }

    //在这个add页面，点击保存之后，进行数据的保存
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addTrue(@Valid Employee employee, BindingResult bindingResult, Model model) {
        boolean b = bindingResult.hasErrors();
        if (b) {
//            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//            HashMap<String, Object> errorsMap = new HashMap<String, Object>();
//            for(FieldError fieldError:fieldErrors){
//                String field = fieldError.getField();
//                String defaultMessage = fieldError.getDefaultMessage();
//                System.out.println("出现了错误:错误字段："+field+",错误信息："+defaultMessage);
//                errorsMap.put(field,defaultMessage);
//            }//为了表单能够回显,覆盖
            model.addAttribute("command",employee);
//            model.addAttribute("exception",errorsMap);
            return "add";//这里需要回显，所以要使用请求转发，因为会拼串，所以使用add.jsp页面
        } else {
            System.out.println(employee);
            employeeDao.save(employee);
            return "redirect:/employees";

        }
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String handleHello() {
        return "redirect:/employees";
    }

    @ModelAttribute()
    public void getEmployee(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (id != null) {
            Employee employee = employeeDao.get(id);
            model.addAttribute("e", employee);
        }
        System.out.println("ok");
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String toEdit(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        //往隐含模型中存入：要回显的employee和departments
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departments);
        return "edit";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String edit(@ModelAttribute("e") Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/quicklyAdd", method = RequestMethod.POST)
    public String quickAdd(@RequestParam("quickAdd") Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/employees";
    }

}
