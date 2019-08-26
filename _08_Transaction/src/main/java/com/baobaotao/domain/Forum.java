package com.baobaotao.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 论坛  Forum论坛 -> Topic主题 -> Post投稿
 */
public class Forum implements Serializable {
    private int forumId;
    private String forumName;
    private String forumDesc;

    public String getForumDesc() {
        return forumDesc;
    }

    public void setForumDesc(String forumDesc) {
        this.forumDesc = forumDesc;
    }

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
