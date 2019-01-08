package com.zc.spring.quartz;
 
public class MyJob {
 
	public void execute() {
		System.out.println("---------执行----MyJob-----");
	}
	
	public void findUserName(String name,Integer age){
		System.out.println("欢迎"+age+"岁的"+name+"光临");
	}
 
}
