package com.zc.controller;

import com.zc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ModelAttribute 可用在
 * 方法上
 * 应用在方法上,且方法也使用了@RequestMapping
 * 方法参数上
 */
// 测试url : http://localhost:8080/t04/test1?number=1
// http://localhost:8080/t04/hello1?number=1
// http://localhost:8080/t04/hello2?number=1
// http://localhost:8080/t04/hello3?number=1
@Controller
@RequestMapping("/t04")
public class T04ModelAttribute {

    // 一.被@ModelAttribute注解的方法会在Controller每个方法执行前都执行
    // 1.使用@ModelAttribute注解无返回值的方法

    /**
     * @param abc
     * @param model
     */
    @ModelAttribute
    public void myModel(@RequestParam(required = false) String abc, Model model) {
        model.addAttribute("attrName", abc);
    }

    // 2.使用@ModelAttribute注解带有返回值的方法
    // 对于有返回值的情况,返回值对象会被默认放到隐含的Model中,在Model中的key为"返回值类型首字母小写",value为返回的值
    @ModelAttribute
    public String myModel2(@RequestParam(required = false) String abc) {
        return abc;// 等同于model.addAttribute("string", abc)
    }

    @ModelAttribute
    public User myModel3(@RequestParam(required = false) String abc) {
        User user = new User();
        user.setName(abc);
        return user;// 等同于model.addAttribute("user", user)
    }

    // 2-2 可以自定义放入model中的key
    @ModelAttribute(value = "num")
    public int myModel4(@RequestParam(required = false, defaultValue = "0") int number) {// number虽然不是必传,但是由于int不能为null.所以不传debug日志里能看到报错. 可以添加defaultValue属性来解决
        return number; // 相当于model.addAttribute("num", number);
    }

    @RequestMapping(value = "/test1")
    public String test1() {
        return "test1";
    }

    // 二.@ModelAttribute应用在方法上,且方法也使用了@RequestMapping
    // 这时这个方法的返回值并不是表示一个视图名称,而是model属性的值.
    // 视图名称由RequestToViewNameTranslator根据请求"/helloWorld"转换为逻辑视图helloWorld.
    // Model属性名称有@ModelAttribute(value="")指定，相当于在request中封装了key=attributeName，value=hi
    @RequestMapping(value = "/hello1")
    @ModelAttribute("attributeName")
    public String hello1() {
        return "hi";
    }

    // 三.@ModelAttribute注释一个方法的参数
    // 1.从model中获取
    // @ModelAttribute("user") User user注释方法参数,参数user的值来源于addAccount()方法中的model属性。
    // 此时如果方法体没有标注@SessionAttributes("user"),那么scope为request.如果标注了,那么scope为session
    @ModelAttribute("user")
    public User addAccount() {
        return new User().setName("zc").setAge(11);
    }

    @RequestMapping(value = "/hello2")
    public String hello2(@ModelAttribute("user") User user) {
        user.setMoney(11.11);
        return "helloWorld";
    }

    // 2.从Form表单或URL参数中获取（实际上，不做此注释也能拿到user对象）
    // 此处多了一个注解@ModelAttribute("user")，它的作用是将该绑定的命令对象以"user"为名称添加到模型对象中供视图页面展示使用。
    // 我们此时可以在视图页面使用${user.username}来获取绑定的命令对象的属性
    @RequestMapping(value = "/hello3")
    public String hello3(@ModelAttribute User user) {
        return "helloWorld3";
    }

    // @ModelAttribute注解类型将参数绑定到Model对象(如此处为User类型)
    @RequestMapping(value = "/modelAttributeTest", method = RequestMethod.POST)
    public String modelAttributeTest(@ModelAttribute User user) {
        System.out.println("modelAttribute Test");
        System.out.println("userid: " + user.getUserId());
        System.out.println("username: " + user.getUserName());
        System.out.println("userpwd: " + user.getUserPwd());
        return "hello";
    }

    /**
     * 当前台界面使用GET或POST方式提交数据时，数据编码格式由请求头的ContentType指定。分为以下几种情况：
     * 1. application/x-www-form-urlencoded，这种情况的数据@RequestParam、@ModelAttribute可以处理，@RequestBody也可以处理。
     * 2. multipart/form-data，@RequestBody不能处理这种格式的数据。（form表单里面有文件上传时，必须要指定enctype属性值为multipart/form-data，意思是以二进制流的形式传输文件。）
     * 3. application/json、application/xml等格式的数据，必须使用@RequestBody来处理。
     * */
}
