package com.zc.spring.quartz;
 
import java.util.List;
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.quartz.ScheduleTask;
import com.quartz.service.TaskService;
 
@ContextConfiguration(locations={"classpath:spring-quartz2.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class QuartzTest {
 
	@Autowired
	private TaskService taskService;
	
	@Test
	public void addTask() throws InterruptedException{
		System.out.println("test--------start----------");
		ScheduleTask task=new ScheduleTask();
		task.setExpression("0/5 * * * * ?");
		task.setId("001");
		task.setGroup("com.quartz.job.MyJob");
		task.setTrigger("findUserName");
		task.setName("task1");
		task.setParam(new Object[]{"zyc",22});
		List<ScheduleTask> list=taskService.getAllTask();
		System.out.println(JSON.toJSONString(list));
//		taskService.addTask(task);
//		Thread.sleep(1000*20);
//		System.out.println("重启定时任务");
//		task.setExpression("0/10 * * * * ?");
//		taskService.reStartTask(task);
		while(true){}
	}
}
