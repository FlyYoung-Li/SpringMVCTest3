package com.web.entity;



/**
 * @author 李晓扬
 * @version 1.0
 * @description: TODO
 * @date 2021/8/1 18:46
 */

public class Teacher {
    private Integer id;
    private String lastName;
    private Integer age;
    private String location;

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", location='" + location + '\'' +
                '}';
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Teacher(Integer id, String lastName, Integer age, String location) {
        this.id = id;
        this.lastName = lastName;
        this.age = age;
        this.location = location;
    }
}
