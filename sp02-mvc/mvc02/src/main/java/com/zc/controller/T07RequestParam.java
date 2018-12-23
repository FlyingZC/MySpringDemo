package com.zc.controller;

import com.zc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

// GET和POST请求传的参数会自动转换赋值到@RequestParam 所注解的变量上
@Controller
@RequestMapping("/t07")
public class T07RequestParam {

    // 零.RequestParam
    // @RequestParam 有三个属性
    // 1.value: 请求参数名(必须配置)
    // 2.required: 是否必需,默认为 true, 即请求中必须包含该参数,如果没有包含,将会抛出异常(可选配置)
    // 3.defaultValue: 默认值,如果设置了该值,required属性将自动被设为false

    // 一.get请求
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)// url: http://localhost:8080/t07/hello1?username=zc&usernick=zcc
    public String requestParamTest(@RequestParam(value = "username") String userName, @RequestParam(value = "usernick") String userNick) {
        System.out.println("requestParam Test");
        System.out.println("username: " + userName);
        System.out.println("usernick: " + userNick);
        return "hello";
    }

    // 上面的@RequestParam(value="usernick")等价于request.getParameter("usernick");
    @RequestMapping(value = "/hello2", method = RequestMethod.GET)// http://localhost:8080/t07/hello2?username=zc&usernick=zcc
    public String requestParamTest(String username, HttpServletRequest request) {
        System.out.println("requestParam Test");
        System.out.println("username: " + username);
        String usernick = request.getParameter("usernick");// 直接从request中取
        System.out.println("usernick: " + usernick);
        return "hello";
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.GET)// http://localhost:8080/t07/hello3?username=zc&usernick=zcc
    public String requestParamTest2(String username, String usernick) {// 也可以不使用@RequestParam,而是直接接收.要求请求中的参数名 和 方法参数中的参数名相同
        System.out.println("requestParam Test");
        System.out.println("username: " + username);
        System.out.println("usernick: " + usernick);
        return "hello";
    }

    // 二.post请求
    // 跟get请求格式一样,只是把方法中的get换成post
    // @RequestParam
    // 用来处理Content-Type: 为 application/x-www-form-urlencoded编码的内容。提交方式为get或post。(Http协议中,如果不指定Content-Type,则默认传递的参数就是application/x-www-form-urlencoded类型)
    // RequestParam实质是将Request.getParameter() 中的Key-Value参数Map利用Spring的转化机制ConversionService配置,转化成参数接收对象或字段。

    // get方式中query String的值,和post方式中body data的值都会被Servlet接受到并转化到Request.getParameter()参数集中,所以@RequestParam可以获取的到。

    @RequestMapping(value="/hi1", method = RequestMethod.POST)
    @ResponseBody  // @RequestBody注解可以接收json格式的数据,并将其转换成对应的数据类型。(如此处转成User类型,下一个demo转成map类型)
    public User findBookByName(@RequestBody User user){// http://localhost:8080/t07/hi1  // content-type: application/json // {"name":"zc"}
        System.out.println("user name: " + user.getName());
        return user;
    }

    @RequestMapping(value="/hi2",method=RequestMethod.POST)// http://localhost:8080/t07/hi2 // content-type: application/json // {"name":"zc","hobbies":"run,go,fly"}
    @ResponseBody
    public void deleteBookById(@RequestBody Map<String, String> map){
        String name = map.get("name");
        String hobbies = map.get("hobbies");
        String[] idArray = name.split(",");
        System.out.println(hobbies);
        System.out.println(Arrays.toString(idArray));
    }


}
