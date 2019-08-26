package com.baobaotao.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * 通过“classpath:”、“file:”等资源地址前缀识别不同的资源类型，还支持Ant风格带通配符的资源地址
 */
public class PatternResolverTest {

    public static void main(String[] args) throws Throwable {
        // PathMatchingResourcePatternResolver将扫描所有类路径下及JAR包中对应com.baobaotao类包下的路径，查询所有以xml为后缀的文件资源
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        Resource resources[] = resolver.getResources("classpath*:com/baobaotao/**/*.xml");
        for (Resource resource : resources) {
            System.out.println(resource.getDescription());
        }
    }
}
