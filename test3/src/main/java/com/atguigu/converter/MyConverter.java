package com.atguigu.converter;

import com.atguigu.dao.DepartmentDao;
import com.atguigu.dao.EmployeeDao;
import com.atguigu.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 * @author 李晓扬
 * @version 1.0
 * @description: TODO
 * @date 2021/7/19 13:49
 */
public class MyConverter implements Converter<String, Employee> {
    @Autowired
    private  DepartmentDao departmentDao;
    @Override
    public Employee convert(String s) {
        //是否包含“-”
        if(s.contains("-")){
            String[] split = s.split("-");
            //创建对象
            Employee employee = new Employee();
            //赋值
            employee.setLastName(split[0]);
            employee.setEmail(split[1]);
            employee.setGender(Integer.parseInt(split[2]));
            employee.setDepartment(departmentDao.getDepartment(Integer.parseInt(split[3])));

            return employee;
        }else{
            return null;
        }

    }
}
