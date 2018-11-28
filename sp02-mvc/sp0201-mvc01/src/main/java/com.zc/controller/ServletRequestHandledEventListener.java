package com.zc.controller;

import java.io.IOException;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.ServletRequestHandledEvent;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Component
public class ServletRequestHandledEventListener implements ApplicationListener<ServletRequestHandledEvent>
{
    public void onApplicationEvent(ServletRequestHandledEvent event)
    {
        System.out.println(event.getDescription());
    }
    
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(RedirectAttributes attr) throws IOException {
        ((FlashMap)((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getAttribute(DispatcherServlet.OUTPUT_FLASH_MAP_ATTRIBUTE)).put("name", "张三丰");
        attr.addFlashAttribute("orderId", "xxx");
        attr.addAttribute("local", "zh-cn");
        return "redirect:showorders";
    }

}
