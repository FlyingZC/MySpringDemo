package com.zc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/hello.do")
	public String hello1(){
		System.out.println("HelloController类中的hello1方法");
		return "hello";
	}
	
	@RequestMapping("/abc/helo2.do")
	public String hello2(){
		System.out.println("HelloController类中的hello2方法");
		return "hello";
	}
}
