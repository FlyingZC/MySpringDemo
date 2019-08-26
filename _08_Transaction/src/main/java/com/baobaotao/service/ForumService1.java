package com.baobaotao.service;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.baobaotao.dao.ForumDao;
import com.baobaotao.domain.Forum;

/**
 * 采用编程式事务管理
 */
public class ForumService1 {
    private ForumDao forumDao;
    // 通过IOC注入
    private TransactionTemplate template;

    public void addForum(final Forum forum) {

        template.execute(new TransactionCallbackWithoutResult() {
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                forumDao.addForum(forum);// 需要在事务环境中执行的代码
            }
        });

    }

    public void setForumDao(ForumDao forumDao) {
        this.forumDao = forumDao;
    }

    public void setTemplate(TransactionTemplate template) {
        this.template = template;
    }


}
