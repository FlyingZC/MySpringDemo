package com.baobaotao.proxy.z03cglib;

/**
 */
public class TestForumService {
    public static void main(String[] args) {
        // CGLIB动态代理
        CglibProxy proxy = new CglibProxy();
        ForumServiceImpl forumService = (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(10);
        forumService.removeTopic(1012);
    }
}
