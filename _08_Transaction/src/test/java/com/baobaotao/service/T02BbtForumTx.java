package com.baobaotao.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.domain.Post;
import com.baobaotao.domain.Topic;

import java.util.Date;

/**
 * xml方式配置事务
 */
public class T02BbtForumTx {
    public static void main(String[] args) throws Throwable {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext-tx.xml");
        BbtForum bbtForum = ctx.getBean(BbtForum.class);

        Date now = new Date();

        System.out.println("begin........");
        // 投稿信息
        Post post = new Post();
        post.setPostText("post content -pfb");
        post.setPostTime(now);

        // 主题信息
        Topic topic = new Topic();
        topic.setTopicTitle("Title -pfb");
        topic.setTopicTime(now);
        topic.setPost(post);// 主题 包含 投稿信息

        // 论坛 添加 主题
        bbtForum.addTopic(topic);
        System.out.println("end........");
    }
}
