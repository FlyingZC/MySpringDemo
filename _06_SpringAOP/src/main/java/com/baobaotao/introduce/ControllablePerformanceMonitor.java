package com.baobaotao.introduce;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * 引介类 Introduction
 * 通过扩展 DelegatingIntroductionInterceptor为目标类引入性能监视的可控功能
 * 实现 Monitorable接口
 * Created by flyingzc on 16/8/2.
 */
public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable {

    private ThreadLocal<Boolean> MonitorStatusMap = new ThreadLocal<Boolean>();

    public void setMonitorActive(boolean active) {
        MonitorStatusMap.set(active);// 开启监控
    }

    // 覆盖了父类中invoke()方法，该方法用于拦截目标类方法的调用，根据监视开关的状态有条件地对目标实例方法进行性能监视
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object obj = null;
        if (MonitorStatusMap.get() != null && MonitorStatusMap.get()) {
            // 开始监控
            PerformanceMonitor.begin(mi.getClass().getName() + "." + mi.getMethod().getName());
            // 调用目标类中的方法
            obj = super.invoke(mi);
            // 结束监控
            PerformanceMonitor.end();
        } else {
            obj = super.invoke(mi);
        }
        return obj;
    }
}
