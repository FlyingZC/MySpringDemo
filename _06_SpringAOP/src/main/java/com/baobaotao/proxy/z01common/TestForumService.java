package com.baobaotao.proxy.z01common;

import com.baobaotao.proxy.CglibProxy;

/**
 */
public class TestForumService {
    public static void main(String[] args) {
        // 普通方式实现
        ForumService forumService = new ForumServiceImpl();
        forumService.removeForum(10);
        forumService.removeTopic(1012);
    }
}
