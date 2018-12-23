package com.zc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/first")
public class FirstController {

    @ResponseBody
    @RequestMapping(value = "/hello")
    public String helloWord() {
        System.out.println("a");
        System.out.println("b");
        System.out.println("c");
        return "hello world";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}