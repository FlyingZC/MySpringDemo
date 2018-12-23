package com.zc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GoController implements EnvironmentAware
{
    private final Log logger = LogFactory.getLog(GoController.class);
    
    // 执行处理前给Model设置("className", "com.zc.xxx")
    @ModelAttribute("className")
    public String setModel() {
        return this.getClass().getName();
    }
    
    // 执行处理前给Model设置("teacher", "老夫子")
    @ModelAttribute
    public void setModel(Model model) {
        model.addAttribute("teacher", "老夫子");
    }
    
    // 执行处理前给Model设置("string", "hehe")
    @ModelAttribute
    public String setModel2(Model model) {
        return "heh";
    }
    
    @RequestMapping(value = {"/"}, method = {RequestMethod.HEAD})
    public String head()
    {
        return "go";
    }

    @RequestMapping(value = {"/index", "/"}, method = {RequestMethod.GET})
    public String index(Model model)
    {
        logger.info("====processed by index====");
        model.addAttribute("msg", "Go go go");
        return "go2";
    }

    private Environment environment = null;

    public void setEnvironment(Environment environment)
    {
        this.environment = environment;
    }

}
