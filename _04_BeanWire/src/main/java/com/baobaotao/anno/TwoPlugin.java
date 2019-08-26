package com.baobaotao.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TwoPlugin implements Plugin {

    /**
     * 如果对类中集合类的变量或方法入参进行@Autowired标注，Spring会将容器中类型匹配的所有Bean都自动注入进来
     */
    @Autowired(required = false)
    private List<Plugin> plugins;

    public List<Plugin> getPlugins() {
        return plugins;
    }
}
