package com.zc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
// 这个处理器类注释了@SessionAttributes， 它将会对book、 description为名称的参数和所有Double类型的参数使用SessionAttributes来缓存
@RequestMapping("/book")
@SessionAttributes(value = {"book", "description"}, types = {Double.class})
@Controller
public class BookController
{
    private final Log logger = LogFactory.getLog(BookController.class);
    // 所以在/book/index请求中将book、 description和price三个参数设置到Model的同时也会自动
    // 设置到SessionAttributes中， 这样在redirect后的getBySessionAttributes处理器方法中就可以获取到
    @RequestMapping("/index")
    public String index(Model model) throws Exception
    {
        model.addAttribute("book", "金刚经");
        model.addAttribute("description", "般若系列重要经典");
        model.addAttribute("price", new Double("999.99"));
        return "redirect:get";
    }

    @RequestMapping("/get")
    public String getBySessionAttributes(@ModelAttribute("book") String book, ModelMap model,
            SessionStatus sessionStatus) throws Exception
    {
        logger.info("==========getBySessionAttributes============");
        logger.info("get by @ModelAttribute:" + book);
        logger.info(
                "get byModelMap:" + model.get("book") + "： " + model.get("description") + "， " + model.get("price"));
        sessionStatus.setComplete();
        return "redirect:complete";
    }

    @RequestMapping("/complete")
    public String afterComplete(ModelMap model) throws Exception
    {
        logger.info("==========afterComplete============");
        logger.info(model.get("book") + "： " + model.get("description") + "， " + model.get("price"));
        return "index";
    }
}
