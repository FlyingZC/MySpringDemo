package com.zc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
//自定义拦截器,需要配置
/*
 * SomeInterceptor类中的preHandle方法
 * HelloController类中的hello1方法
 * SomeInterceptor类中的postHandle方法
 * SomeInterceptor类中的afterCompletion方法
 * */
public class SomeInterceptor implements HandlerInterceptor{
	/* 
	 * handler参数,用于获得处理器方法描述的对象
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("SomeInterceptor类中的preHandle方法");
		//若返回值为false,则请求结束.若返回值为true,则请求继续
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println(handler);
		System.out.println("SomeInterceptor类中的postHandle方法");
	}
	//处理器可以将异常抛出,该异常可以在这个方法中捕获
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("SomeInterceptor类中的afterCompletion方法");
	}
	
}
