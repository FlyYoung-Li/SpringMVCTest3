package com.atguigu.entities;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.sql.Date;


public class Employee {

    private Integer id;
    @NotEmpty(message = "数据不能为空")
    @Length(min = 1,max = 10,message = "长度不正确，必须再1-10之间")
    private String lastName;
    @Email(message = "邮箱格式不正确")
    private String email;
    //1 male, 0 female
    private Integer gender;
    private Department department;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee(Integer id, @NotEmpty(message = "数据不能为空") @Length(min = 1, max = 10, message = "长度不正确，必须再1-10之间") String lastName, @Email(message = "邮箱格式不正确") String email, Integer gender, Department department, Date date) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.date = date;
    }

    public Employee(Integer id, @NotEmpty(message = "数据不能为空") @Length(min = 1, max = 10, message = "长度不正确，必须再1-10之间") String lastName, @Email(message = "邮箱格式不正确") String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", department=" + department +
                ", date=" + date +
                '}';
    }
}
