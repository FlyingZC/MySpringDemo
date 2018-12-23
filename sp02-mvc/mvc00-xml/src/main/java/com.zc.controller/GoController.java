package com.zc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GoController implements EnvironmentAware
{
    private final Log logger = LogFactory.getLog(GoController.class);

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
