package com.zc.springaction.p02.springidol;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 表演大厅
 * 在表演开始前开灯,在表演结束时关灯
 */
public class Auditorium implements InitializingBean, DisposableBean
{
    public void turnOnLights()
    {
        System.out.println("表演大厅开灯.Turn on lights in auditorium..");
    }

    public void turnOffLights()
    {
        System.out.println("表演大厅关灯.Turn off lights in auditorium..");
    }

    public void destroy() throws Exception
    {
        System.out.println("Auditorium类实现DisposableBean接口的destroy方法");
    }

    public void afterPropertiesSet() throws Exception
    {
        System.out.println("Auditorium类实现InitializingBean接口的afterPropertiesSet方法");
    }
}
