package com.zc.test;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValue;

public class T01BeanWrapper
{
    public static void main(String[] args)
    {
        User user = new User();
        // 使用PropertyAccessorFactory 将对象封装成BeanWrapper对象,这样就可以使用BeanWrapper对象对user属性进行操作了
        BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(user);
        bw.setPropertyValue("userName", "张三");
        System.out.println(user.getUserName());// 张三
        
        PropertyValue value = new PropertyValue("userName", "李四");
        bw.setPropertyValue(value);
        System.out.println(user.getUserName());// 李四
    }
}

class User {
    String userName;

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
}