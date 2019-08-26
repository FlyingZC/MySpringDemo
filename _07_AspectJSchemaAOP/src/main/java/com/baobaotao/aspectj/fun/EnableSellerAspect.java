package com.baobaotao.aspectj.fun;

import com.baobaotao.Seller;
import com.baobaotao.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EnableSellerAspect {
    @DeclareParents(value = "com.baobaotao.NaiveWaiter",
            defaultImpl = SmartSeller.class)
    public Seller seller;
}
