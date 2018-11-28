package knights;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import knights.MyTestBean;

import static org.junit.Assert.assertEquals;

/**
 * Created by vonzhou on 16/4/1.
 *
 */
public class BeanFactoryTest {
    @Test
    public void testSimpleLoad(){
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("knights/knights.xml"));
        MyTestBean bean = (MyTestBean)bf.getBean("myTestBean");
        assertEquals("testStr", bean.getTestStr());
    }
}
