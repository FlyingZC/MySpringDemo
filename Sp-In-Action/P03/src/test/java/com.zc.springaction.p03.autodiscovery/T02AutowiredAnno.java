package com.zc.springaction.p03.autodiscovery;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用@Autowired注解
 */
public class T02AutowiredAnno
{
    ApplicationContext context = new ClassPathXmlApplicationContext(TestConstants.BASE_RES_DIR +
            "spring02-autodiscovery.xml");

    @Test
    public void test0() throws Exception
    {
        // byType装配
        Instrumentalist1 instrumentalist2 = (Instrumentalist1) context.getBean("kenny");
        System.out.println(instrumentalist2.getInstrument().getClass());
    }

}
