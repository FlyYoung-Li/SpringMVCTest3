package pojo;

import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author 李晓扬
 * @version 1.0
 * @description: TODO
 * @date 2021/7/4 10:59
 */
public class User {
    private String username;
    private Integer age;
    private String gender;
    private String locale;

    public User(String username, Integer age, String gender, String locale) {
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.locale = locale;
    }

    public User() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", locale='" + locale + '\'' +
                '}';
    }
}
