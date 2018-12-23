package com.zc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zc.entity.User;

@Controller
@RequestMapping("/valid")
public class ValidateController
{
    @Autowired
    private com.zc.controller.UserValidator validator;
    
    // 将校验器添加到Binder中.
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        // WebDataBinder添加校验器有两种方式:1.addValidators():在原有基础上添加; 2.setValidator():直接覆盖设置
        binder.addValidators(validator);
    }
    
    @RequestMapping(value={"/signup"}, method = {RequestMethod.POST})
    public String signup(@RequestBody @Valid User user, BindingResult br, RedirectAttributes ra) throws Exception{
        ra.addFlashAttribute("user", user);
        return "user.jsp";
    }
}

