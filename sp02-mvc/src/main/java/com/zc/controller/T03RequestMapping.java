package com.zc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/home")
public class T03RequestMapping {
    private static final String NAME = T03RequestMapping.class.getSimpleName();

    /**
     * RequestMapping注解
     * RequestMapping是一个用来处理请求地址映射的注解,可用于类或方法上.
     * 用于类上,表示类中的所有响应请求的方法都是以该地址作为父路径.
     * <p>
     * RequestMapping注解有六个属性
     * 1、value, method
     * value: 指定请求的实际地址,指定的地址可以是URI Template 模式
     * method:  指定请求的method类型, GET、POST、PUT、DELETE等
     * <p>
     * 2、consumes,produces
     * consumes:  指定处理请求的提交内容类型（Content-Type）,例如 application/json, text/html;
     * produces:  指定返回的内容类型,仅当request请求头中的(Accept)类型中包含该指定类型才返回;
     * <p>
     * 3、params,headers
     * params:  指定request中必须包含某些参数值时,才让该方法处理.
     * headers: 指定request中必须包含某些指定的header值,才能让该方法处理请求.
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/")
    public String hello() {
        System.out.println(NAME + ".hello()");
        return "hello world2";
    }

    /**
     * 404示例. 与Hello2区别.缺少@ResponseBody注解.可以走到这个方法里,可能没有给客户端返回数据? 添加ResponseBody后可在请求的response中看到返回数据 NO. 应该是找不到该页面,看debug日志YES
     *
     * @return
     */
    @RequestMapping(value = "/hello1")
    public String hello1() {
        System.out.println(NAME + ".hello2()");
        return "hello world2";
    }

    @ResponseBody
    @RequestMapping(value = "/hello2")
    public String hello2() {
        System.out.println(NAME + ".hello2()");
        return "hello world2";
    }

    // 三.可以将多个请求映射到一个方法上去,只需要添加一个带有请求路径值列表的 @RequestMapping 注解就行了.
    // @RequestMapping 支持统配符以及ANT风格的路径
    @ResponseBody
    @RequestMapping(value = {
            "",
            "/page",
            "page*",
            "bf/*",
            "**/end",
            "view/*,**/msg"  // 这一行中间有个逗号,但是是整体.能匹配这样的/home/view/a,b/msg
    })
    public String indexMultipleMapping() {
        return "Hello from index multiple mapping.";
    }


    // 四.@RequestMapping配合@RequestParam
    // @RequestMapping 注解配合 @RequestMapping 一起使用,可以将请求的参数同处理方法的参数绑定在一起.
    // @RequestParam 注解使用的时候可以有一个值,也可以没有值.这个值指定了需要被映射到处理方法参数的请求参数
    @RequestMapping(value = "/query1")
    @ResponseBody
    public String getIdByValue(@RequestParam("name") String personId) {// 匹配如 http://localhost:8080/home/query1?name='zc'  // 其中RequestParam("name")对应?号后面的
        System.out.println("ID is " + personId);
        return "Get ID from query string of URL with value element " + personId;
    }

    @RequestMapping(value = "/query2")
    @ResponseBody
    public String getId(@RequestParam String personId) {// http://localhost:8080/home/query2?personId='zc'
        System.out.println("ID is " + personId);
        return "Get ID from query string of URL without value element " + personId;
    }

    @RequestMapping(value = "/query3")
    public String getName(@RequestParam(value = "personId", required = false) String personId) {
        return "Required element of request param " + personId;
    }

    @RequestMapping(value = "/query4")
    public String getName2(@RequestParam(value = "person", defaultValue = "John") String personName) {
        return "Required element of request param";
    }

    // 五.用 @RequestMapping 处理 HTTP 的各种方法
    // 所有的处理处理方法会处理从这同一个 URL( /home)进来的请求, 但要看指定的 HTTP 方法是什么来决定用哪个方法来处理
    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "Hello from get";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String delete() {
        return "Hello from delete";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String post() {
        return "Hello from post";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String put() {
        return "Hello from put";
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public String patch() {
        return "Hello from patch";
    }

    // 六.用 @RequestMapping 来处理生产和消费对象. 使用 @RequestMapping 注解的 produces 和 consumes 这两个元素来缩小请求映射类型的范围
    @RequestMapping(value = "/prod", produces = {
            "application/JSON"
    })
    @ResponseBody
    public String getProduces() {// getProduces() 处理方法会产生一个 JSON 响应给客户端. 查看response的Content-Type: application/json
        return "Produces attribute";
    }

    //
    @RequestMapping(value = "/cons", consumes = {
            "application/JSON",
            "application/XML"
    })
    public String getConsumes() {// getConsumes() 处理方法可以同时处理请求中的 JSON 和 XML 内容
        return "Consumes attribute";
    }

    // 七.@RequestMapping 注解提供了一个 header 元素来根据请求中的消息头内容缩小请求映射的范围.
    @RequestMapping(value = "/head", headers = {
            "content-type=text/plain"
    })
    public String testHeader() {
        return "Mapping applied along with headers";
    }

    @RequestMapping(value = "/head2", headers = {
            "content-type=text/plain",
            "content-type=text/html"
    })
    public String testHead2() {
        return "Mapping applied along with headers";
    }


    // 八.@RequestMapping 直接的 params 元素可以进一步帮助我们缩小请求映射的定位范围.使用 params 元素,
    // 你可以让多个处理方法处理到同一个URL 的请求, 而这些请求的参数是不一样的
    @RequestMapping(value = "/fetch", params = {// getParams() 和 getParamsDifferent() 两个方法都能处理相同的一个 URL (/home/fetch) ,但是会根据 params 元素的配置不同而决定具体来执行哪一个方法
            "personId=10"
    })
    public String getParams(@RequestParam("personId") String id) {
        return "Fetched parameter using params attribute = " + id;
    }

    @RequestMapping(value = "/fetch", params = {
            "personId=20"
    })
    public String getParamsDifferent(@RequestParam("personId") String id) {
        return "Fetched parameter using params attribute = " + id;
    }


    // 九.@RequestMapping 注解可以同 @PathVaraible 注解一起使用,用来处理动态的 URI,URI 的值可以作为控制器中处理方法的参数.
    // 你也可以使用正则表达式来只处理可以匹配到正则表达式的动态 URI.
    @RequestMapping(value = "/fetch/{id}", method = RequestMethod.GET)
    public String getDynamicUriValue(@PathVariable String id) {
        System.out.println("ID is " + id);
        return "Dynamic URI parameter fetched";
    }

    @RequestMapping(value = "/fetch/{id:[a-z]+}/{name}", method = RequestMethod.GET)
    public String getDynamicUriValueRegex(@PathVariable("name") String name) {
        System.out.println("Name is " + name);
        return "Dynamic URI parameter fetched using regex";
    }

}
