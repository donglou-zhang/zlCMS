package com.cms.zl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by Vincent on 2016/12/25.
 */
@Entity
public class Comment extends ParentEntity {
    @Column(nullable = false)
    private String comment_text;

    //optional默认为true，此时为left join；如果为false，则为inner join
    @ManyToOne(optional = false)
    private Article article;

    @ManyToOne(optional = false)
    private User user;

    public Comment() {

    }

    public Comment(String context, Article article, User user) {
        this.comment_text = context;
        this.article = article;
        this.user = user;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
