package com.zc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @PathVariable 用于将请求URL中的模板变量映射到功能处理方法的参数上, 即取出uri模板中的变量作为参数
 */
@Controller
@RequestMapping(value = "/t06")
public class T06PathVariable {

    @RequestMapping(value = "/user/{userId}/roles/{roleId}", method = RequestMethod.GET)
    public String getLogin(@PathVariable("userId") String userId,
                           @PathVariable("roleId") String roleId) {// 测试url: http://localhost:8080/t06/user/zc/roles/zrole
        System.out.println("User Id : " + userId);
        System.out.println("Role Id : " + roleId);
        return "hello";
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public String getProduct(@PathVariable("productId") String productId) {// 测试url: http://localhost:8080/t06/product/zpro
        System.out.println("Product Id : " + productId);
        return "hello";
    }

    @RequestMapping(value = "/javabeat/{regexp1:[a-z-]+}",
            method = RequestMethod.GET)
    public String getRegExp(@PathVariable("regexp1") String regexp1) {// 测试url: http://localhost:8080/t06/product/zpro
        System.out.println("URI Part 1 : " + regexp1);
        return "hello";
    }
}
