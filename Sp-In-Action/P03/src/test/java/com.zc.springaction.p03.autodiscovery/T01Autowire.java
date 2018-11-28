package com.zc.springaction.p03.autodiscovery;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Assert;

public class T01Autowire
{
    ApplicationContext context = new ClassPathXmlApplicationContext(TestConstants.BASE_RES_DIR + "spring01-autowire.xml");;

    @Test
    public void test0() throws Exception
    {
        // byName装配
        Instrumentalist1 instrumentalist1 = (Instrumentalist1) context.getBean("kenny");
        System.out.println(instrumentalist1.getInstrument().getClass());
        
        // byType装配
        Instrumentalist1 instrumentalist2 = (Instrumentalist1) context.getBean("kenny2");
        /*org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'kenny2' defined in class path resource [com/zc/springaction/p03/spring01-autowire.xml]: 
            Unsatisfied dependency expressed through bean property 'instrument': 
                : No qualifying bean of type [com.zc.springaction.p03.autodiscovery.Instrument] is defined: 
                    expected single matching bean but found 2: instrument,instrument2; */
    }

}
