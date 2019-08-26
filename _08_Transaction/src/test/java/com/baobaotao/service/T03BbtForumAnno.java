package com.baobaotao.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.domain.Post;
import com.baobaotao.domain.Topic;


/**
 * 注解方式配置事务
 */
public class T03BbtForumAnno {

    public static void main(String[] args) throws Throwable {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext-anno.xml");
        BbtForum bbtForum = ctx.getBean(BbtForum.class);

        System.out.println("begin........");
        Topic topic = new Topic();
        topic.setTopicTitle("Title -pfb");

        Post post = new Post();
        post.setPostText("post content -pfb");
        topic.setPost(post);
        bbtForum.addTopic(topic);

        System.out.println("end........");
    }
}
