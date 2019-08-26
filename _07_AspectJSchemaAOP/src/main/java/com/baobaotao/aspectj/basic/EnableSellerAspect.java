package com.baobaotao.aspectj.basic;

import com.baobaotao.Seller;
import com.baobaotao.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * 包含引介增强注解的切面
 */
@Aspect
public class EnableSellerAspect {
    // 1. 用切面技术 为 NaiveWaiter新增 Seller接口的实现
    // 引介增强 注解
    // value属性: 定义切点,它表示在哪个目标类上添加引介增强
    // defaultImpl属性: 默认的接口实现类
    @DeclareParents(value = "com.baobaotao.NaiveWaiter",// 为NaiveWaiter类 添加接口实现
            defaultImpl = SmartSeller.class)// 默认的接口实现类
    public Seller seller;// 要实现的目标接口

    // 2. “在Spring配置文件中配置好 切面 和 NaiveWaiter Bean”
}
