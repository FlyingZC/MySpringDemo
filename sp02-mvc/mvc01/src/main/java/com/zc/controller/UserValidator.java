package com.zc.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.zc.entity.User;
// 校验器
@Component
public class UserValidator implements Validator
{

    public boolean supports(Class<?> clazz)
    {
        return User.class.equals(clazz);
    }

    public void validate(Object obj, Errors errors)
    {
        User user = (User) obj;
        if (user.getUserName().length() < 8) {
            errors.rejectValue("userName", "valid.usrNameLen", new Object[]{"minLength", 8}, "用户名不能少于{1}位");
        }
    }

}