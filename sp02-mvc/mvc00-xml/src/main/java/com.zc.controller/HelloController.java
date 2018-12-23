package com.zc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("HelloController类中的handleRequest方法");
		//创建一个ModelAndView对象
		/* 第一个
		 * ModelAndView提供了两个构造器
		 * ModelAndView(String viewName)
		 * viewName为视图名
		 * 第二个
		 * ModelAndView(String viewName,Map data)
		 * data是处理结果
		*/
		return new ModelAndView("hello");
	}
}
