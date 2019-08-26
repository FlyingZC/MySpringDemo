package com.baobaotao.context.anno;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AnnoBeansAware implements ApplicationContextAware {

    private static Map<String, Object> map = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        Map<String, Object> beanMap = ctx.getBeansWithAnnotation(MyAnno.class);
        if (beanMap != null && !beanMap.isEmpty()) {
            for (Object bean : beanMap.values()) {
                String code = bean.getClass().getAnnotation(MyAnno.class).code();
                map.put(code, bean);
                System.out.println("扫描到带有 MyAnno 注解的 bean");
            }
        }
    }

    public static Map<String, Object> getMap() {
        return map;
    }

    public static void setMap(Map<String, Object> map) {
        AnnoBeansAware.map = map;
    }
}
