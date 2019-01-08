package com.zc.quartztest;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SwapJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("我现在是每20秒 打印一次哦");
    }

}