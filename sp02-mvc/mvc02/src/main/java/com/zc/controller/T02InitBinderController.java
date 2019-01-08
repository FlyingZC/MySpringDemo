package com.zc.controller;

import com.zc.entity.User;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/t02")
public class T02InitBinderController {

    @ResponseBody
    @RequestMapping(value = "/hello0")
    public String hello0(String str) {
        System.out.println("str: " + str);
        return "hello world";
    }

    @ResponseBody
    @RequestMapping(value = "/hello1")
    public String hello1(String str) {
        System.out.println("str: " + str);
        return "hello world";
    }

    @ResponseBody
    @RequestMapping(value = "/hello")
    public String helloWord(@ModelAttribute("user") User user, @RequestParam Date date) {
        System.out.println("" + user.getBirth() + user.getAge() + user.getMoney());
        return "hello world";
    }

    /**
     * @InitBinder用于在@Controller中标注于方法上,表示为当前控制器注册一个属性编辑器,只对当前的Controller有效.
     *
     * 页面某些数据类型是Date、Integer、Double等的数据要绑定到控制器的实体,
     * 或者控制器需要接受这些数据,如果这类数据类型不做处理的话将无法绑定.
     * 可以使用注解@InitBinder来解决这些问题,这样SpringMVC在绑定表单之前,都会先注册这些编辑器.
     */
    @InitBinder
    protected void myInitBinder(WebDataBinder binder) {
        // WebDataBinder binder用来绑定请求参数 到 指定的属性编辑器.用于完成由表单到JavaBean属性的绑定

        // 由于前台传到controller里的值是String类型的,当往Model里set这个值的时候,
        // 如果set的这个属性是个对象,Spring就会去找到对应的customEditor进行转换,然后再set进去

        // 比如,此时若Model是Date类型,则spring会调用MyDateEditor处理前台上次的字符串,然后再set进去
        binder.registerCustomEditor(Date.class, new MyDateEditor());// 所谓的属性编辑器可以理解就是帮助我们完成参数绑定
        binder.registerCustomEditor(Double.class, new DoubleEditor());
        binder.registerCustomEditor(Integer.class, new IntegerEditor());
    }

    // 对Date类型进行处理的属性编辑器(将前台string参数 转化成 后台Date对象)
    private class MyDateEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = null;
            try {
                date = format.parse(text);
            } catch (ParseException e) {
                format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    date = format.parse(text);
                } catch (ParseException e1) {
                }
            }
            setValue(date);
        }
    }

    public class DoubleEditor extends PropertiesEditor {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            if (text == null || text.equals("")) {
                text = "0";
            }
            setValue(Double.parseDouble(text));
        }

        @Override
        public String getAsText() {
            return getValue().toString();
        }
    }

    public class IntegerEditor extends PropertiesEditor {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            if (text == null || text.equals("")) {
                text = "0";
            }
            setValue(Integer.parseInt(text));
        }

        @Override
        public String getAsText() {
            return getValue().toString();
        }
    }

}