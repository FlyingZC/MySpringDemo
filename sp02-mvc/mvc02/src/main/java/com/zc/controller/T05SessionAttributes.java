package com.zc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.Map;

/**
 * 该注解只能用在类上
 * 默认情况下Spring MVC将模型中的数据存储到request域中。当一个请求结束后，数据就失效了。
 * 如果要跨页面使用。那么需要使用到session。而@SessionAttributes注解就可以使得模型中的数据存储一份到session域中。
 */
@SessionAttributes(value={"names"}, types={Integer.class})
@Controller
@RequestMapping(value="/t05")
public class T05SessionAttributes {

    /**
     * @SessionAttributes参数
     * 1、names：这是一个字符串数组。里面应写需要存储到session中数据的名称。
     * 2、types：根据指定参数的类型，将模型中对应类型的参数存储到session中
     * 3、value：其实和names是一样的。
     */
    @RequestMapping("/test")
    public String test(Map<String, Object> map) {
        map.put("names", Arrays.asList("za", "zb", "zc"));
        map.put("age", 18);
        return "T05SessionAttributes";
    }
}
