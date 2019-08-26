package com.baobaotao.service.impl;

import java.sql.SQLException;

import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.transaction.annotation.Transactional;

import com.baobaotao.dao.ForumDao;
import com.baobaotao.dao.PostDao;
import com.baobaotao.dao.TopicDao;
import com.baobaotao.domain.Forum;
import com.baobaotao.domain.Topic;
import com.baobaotao.service.BbtForum;

@Transactional
// @Transactional注解本身具有一组普适性的默认事务属性，所以往往只要为需要事务管理的业务类中添加上一个@Transactional注解就完成了业务类事务属性的配置
public class BbtForumImpl implements BbtForum {
    private ForumDao forumDao;
    private TopicDao topicDao;
    private PostDao postDao;

    public void addTopic(Topic topic) throws Exception {
        // 添加 主题
        topicDao.addTopic(topic);
        // 用于模拟异常发生时,事务是否会生效
        // if (true) throw new PessimisticLockingFailureException("fail");
        // 添加 投稿
        postDao.addPost(topic.getPost());
    }

    @Transactional(readOnly = true)
    public Forum getForum(int forumId) {
        return forumDao.getForum(forumId);
    }

    public void updateForum(Forum forum) {
        forumDao.updateForum(forum);
    }

    public int getForumNum() {
        return forumDao.getForumNum();
    }

    public void setForumDao(ForumDao forumDao) {
        this.forumDao = forumDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }
}
