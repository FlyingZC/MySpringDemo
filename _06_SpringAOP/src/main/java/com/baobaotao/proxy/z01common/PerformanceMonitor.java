package com.baobaotao.proxy.z01common;

/**
 * 性能监控类
 */
public class PerformanceMonitor {
    private static ThreadLocal<MethodPerformance> performanceRecord = new ThreadLocal<MethodPerformance>();

    // 开始对某个目标类方法的监视
    public static void begin(String method) {
        System.out.println("begin monitor...");
        MethodPerformance mp = performanceRecord.get();
        if (mp == null) {
            mp = new MethodPerformance(method);
            performanceRecord.set(mp);
        } else {
            mp.reset(method);
        }
    }

    // 结束对某个目标类方法的监视
    public static void end() {
        System.out.println("end monitor...");
        MethodPerformance mp = performanceRecord.get();
        mp.printPerformance();
    }
}
