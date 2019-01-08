package com.zc.quartztest;

public class Test {
    public static void main(String[] args) {
        // addJob(任务名称, 具体需要完成的任务, 时间间隔)
        QuartzManager.addJob("获取dept数据", SwapJob.class, "0/20 * * * * ?");
    }
}
