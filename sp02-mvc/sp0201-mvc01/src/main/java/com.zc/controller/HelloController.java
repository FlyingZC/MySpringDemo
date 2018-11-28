package com.zc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.zc.entity.AdminParam;

/**
 * @author zc
 * 处理器类
 * 1.不用实现Controller接口
 * 2.可以添加多个方法
 * 3.方法名不做要求,返回值类型可以是ModelAndView,也可以为字符串
 * 4.在类前添加@Controller注解
 * 5.使用@RequestMapping来告诉DispatcherServlet,请求路径与处理器的对应关系
 */
//则spring-mvc.xml中的HandlerMapping(本类中使用@RequestMapping配置)和Controller处理器(本类加了@Controller注解)无需再配置
@Controller
@RequestMapping("/common")
//http://localhost:8080/ZC11Springmvc/common/hello.do
public class HelloController {
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("HelloController类中的hello方法");
		return "hello";
	}
	
	@RequestMapping("/hello2.do")
	public String hello2(){
		System.out.println("HelloController类中的hello2方法");
		return "hello";
	}
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("HelloController类中的toLogin方法");
		return "login";
	}
	//Controller会被DispatcherServlet调用,当dispatcherServlet调用时,会利用反射机制分析方法的结构,
	//当发现有HttpServletRequest时,dispatcherServlet会将该对象传入该方法中来
	@RequestMapping("/login.do")
	public String checkLogin(HttpServletRequest request){//使用request读取请求参数值
		System.out.println("HelloController类中的checkLogin方法");
		String adminCode=request.getParameter("adminCode");
		String pwd=request.getParameter("pwd");
		System.out.println(adminCode+pwd);
		return "index"; 
	}
	
	@RequestMapping("/login2.do")
	//获取请求参数值的第二种方式,使用@RequestParam(String param),param是实际参数名.
	//注:建议:即使实际请求参数名与形参名一致,也要添加@RequestParam进行说明
	//默认情况下不知道形参名字,前端控制器调用该方法时分析该方法结构,eclipse编译时将该形参名信息加入到字节码中.推荐加注解
	public String checkLogin2(String adminCode,@RequestParam("pwd")String pwdpp){//参数名和传入的参数名相同
		System.out.println("HelloController类中的checkLogin2方法");
		System.out.println(adminCode+" "+pwdpp);
		return "index";
	}
	//请求参数值的第三种方式,封装成一个javabean
	@RequestMapping("/login3.do")
	public String checkLogin3(AdminParam ap){//javabean	AdminParam
		System.out.println(ap.getAdminCode());
		System.out.println(ap.getPwd());
		return "index";
	}
	
	//**************************向页面传值
	//方式1:使用request对象
	@RequestMapping("/login4.do")
	public String checkLogin4(AdminParam ap,HttpServletRequest request){
		System.out.println("HelloController类中的checkLogin4方法");
		request.setAttribute("adminCode", ap.getAdminCode());
		//springmvc默认使用转发!!!!,所以不用获取转发器
		return "index";
	}
	//方式2:使用session向页面传值
	@RequestMapping("/login5.do")
	public String checkLogin5(AdminParam ap,HttpSession session){
		System.out.println("HelloController类中的checkLogin5方法");
		session.setAttribute("adminCode", ap.getAdminCode());
		return "index";
	}
	
	//方式3:通过ModelMap对象,会将ModelMap中的参数绑定到request对象上,相当于request.setAttribute
	@RequestMapping("/login6.do")
	public String checkLogin6(AdminParam ap,ModelMap mm){
		System.out.println("HelloController类中的checkLogin6方法");
		/*
		 * 相当于将数据绑定到了request对象,绑定名就是adminCode
		 * 相当于request.setAttribute
		 * */
		mm.addAttribute("adminCode",ap.getAdminCode());
		return "index";
	}
	
	//方式4:通过ModelAndView对象,将处理结果添加到ModelAndView对象里
	@RequestMapping("/login7.do")
	public ModelAndView checkLogin7(AdminParam ap){
		System.out.println("HelloController类中的checkLogin7方法");
		Map<String, String> data = new HashMap<String,String>();
		//相当于将数据绑定到了request上
		data.put("adminCode", ap.getAdminCode());
		return new ModelAndView("index",data);
	}
	
	//重定向
	//重定向的第一种方式
	@RequestMapping("/login8.do")
	public String checkLogin8(){
		System.out.println("HelloController类中的checkLogin8方法");
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "index";
	}
	
	//重定向的第二种方式
	@RequestMapping("/login9.do")
	public ModelAndView checkLogin9(){
		System.out.println("HelloController类中的checkLogin9方法");
		RedirectView rv=new RedirectView("toIndex.do");
		return new ModelAndView(rv);
	}
	
	
	
}
