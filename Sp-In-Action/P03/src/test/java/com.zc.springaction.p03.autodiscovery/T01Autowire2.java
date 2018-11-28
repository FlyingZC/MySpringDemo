package com.zc.springaction.p03.autodiscovery;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class T01Autowire2
{
    ApplicationContext context = new ClassPathXmlApplicationContext(TestConstants.BASE_RES_DIR +
            "spring01-autowire2-byType.xml");

    @Test
    public void test0() throws Exception
    {
        // byType装配
        Instrumentalist1 instrumentalist2 = (Instrumentalist1) context.getBean("kenny2");
        System.out.println(instrumentalist2.getInstrument().getClass());
    }

}
