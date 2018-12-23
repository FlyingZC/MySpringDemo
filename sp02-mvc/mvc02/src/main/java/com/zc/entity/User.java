package com.zc.entity;

import java.util.Date;

public class User {
    Date birth;
    Double money;
    Integer age;
    String name;

    String userId;
    String userName;
    String userPwd;

    String hobbies;

    public User() {

    }

    public Date getBirth() {
        return birth;
    }

    public User setBirth(Date birth) {
        this.birth = birth;
        return this;
    }

    public Double getMoney() {
        return money;
    }

    public User setMoney(Double money) {
        this.money = money;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public User setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public User setUserPwd(String userPwd) {
        this.userPwd = userPwd;
        return this;
    }

    public String getHobbies() {
        return hobbies;
    }

    public User setHobbies(String hobbies) {
        this.hobbies = hobbies;
        return this;
    }
}