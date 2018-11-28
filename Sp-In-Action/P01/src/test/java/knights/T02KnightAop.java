package knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T02KnightAop
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "/knights/knights-aop.xml");

        Knight knight = (Knight) context.getBean("knight");

        knight.embarkOnQuest();
    }
}
