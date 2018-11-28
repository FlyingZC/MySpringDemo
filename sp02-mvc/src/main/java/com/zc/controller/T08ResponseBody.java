package com.zc.controller;

import com.zc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping(value="/t08")
public class T08ResponseBody {
    // @RequestBody是作用在形参列表上,用于将前台发送过来固定格式的数据(xml 或json等)封装成对应的JavaBean对象,
    // 封装时使用到的一个对象是系统默认配置的 HttpMessageConverter进行解析,然后封装到形参上
    @RequestMapping(value="/hi1", method = RequestMethod.POST)
    @ResponseBody  // @RequestBody注解可以接收json格式的数据,并将其转换成对应的数据类型。(如此处转成User类型,下一个demo转成map类型)
    public User findBookByName(@RequestBody User user){// http://localhost:8080/t08/hi1  // content-type: application/json // {"name":"zc"}
        System.out.println("user name: " + user.getName());
        return user;
    }

    @RequestMapping(value="/hi2",method=RequestMethod.POST)// http://localhost:8080/t08/hi2 // content-type: application/json // {"name":"zc","hobbies":"run,go,fly"}
    @ResponseBody
    public void deleteBookById(@RequestBody Map<String, String> map){// 转成map类型
        String name = map.get("name");
        String hobbies = map.get("hobbies");
        String[] idArray = name.split(",");
        System.out.println(hobbies);
        System.out.println(Arrays.toString(idArray));
    }
}
