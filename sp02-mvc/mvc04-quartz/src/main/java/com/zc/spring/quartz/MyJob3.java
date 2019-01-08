package com.zc.spring.quartz;
 
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
 
@Component
public class MyJob3 {
 
	@Scheduled(cron="0/5 * * * * ?")
	public void execute(){
		System.out.println("------执行注解实现的定时任务-----");
	}
}
