package com.zc.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//springmvc中的ContextLoaderListener也实现了ServletContextListener接口
//使用ServletContextListener接口,开发者能在为客户端请求提供服务前 向ServletContext中添加任意对象
public class MyServletContextListener implements ServletContextListener
{
    private ServletContext context=null;
    
    /**
     * 该方法在ServletContext将要关闭时调用
     * @param event
     */
    public void contextDestroyed(ServletContextEvent event)
    {
        this.context=null;
        System.out.println("ServletContextListener contextDestroyed----");
    }

    /**
     * 该方法在ServletContext启动之后被调用,并准备好处理客户端请求
     * @param event
     */
    public void contextInitialized(ServletContextEvent event)
    {
        this.context=event.getServletContext();
        //在ServletContext中设置自己的属性
        context.setAttribute("myData", "this is myDatazz");
    }

}
