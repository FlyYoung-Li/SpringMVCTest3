package com.atguigu.entity;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author 李晓扬
 * @version 1.0
 * @description: TODO
 * @date 2021/7/24 11:44
 */
public class Employee {
    private Integer id;
    @NotEmpty
    @Length(min = 1,max = 8)
    private String name;
    private Integer age;
    @Email
    private String email;
    //util包与sql包下，这是侧重点不同（java.util public class Date）
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    //这里说明了，ajax处理请求，是另一套方法，如果上一行注掉，那么，ajax不会执行
    //说明这是在指定这个日期格式变成JSON字符串的检验格式
    private Date birth = new Date();

    public Employee(Integer id, String name, Integer age, String email, Date birth) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.birth = birth;
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                '}';
    }
}
