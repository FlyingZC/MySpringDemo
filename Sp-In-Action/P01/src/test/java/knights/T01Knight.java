package knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T01Knight {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("/knights/knights.xml");

        Knight knight = (Knight) context.getBean("knight");

        knight.embarkOnQuest();
    }   
}
