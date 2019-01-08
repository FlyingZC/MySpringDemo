package com.zc.spring.quartz;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ManagerJob implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    private TaskService taskService;

    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        ApplicationContext applicationContext = arg0.getApplicationContext();
        String[] beans = applicationContext.getBeanDefinitionNames();
        for (String bean : beans) {
            Class<?> class1 = applicationContext.getBean(bean).getClass();
            Method[] methods = class1.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Scheduled.class)) {
                    Scheduled annotation = method.getAnnotation(Scheduled.class);
                    ScheduleTask scheduleTask = new ScheduleTask();
                    scheduleTask.setGroup(class1.getName());
                    scheduleTask.setTrigger(method.getName());
                    scheduleTask.setId(String.valueOf(SnowflakeIdWorker.getInstance().nextId()));
                    scheduleTask.setExpression(annotation.cron());
                    scheduleTask.setParam(new Object[]{});
                    scheduleTask.setName("task2");
                    taskService.addTask(scheduleTask);
                }
            }
        }
    }

}
