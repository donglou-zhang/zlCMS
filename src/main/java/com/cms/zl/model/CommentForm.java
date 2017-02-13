package com.cms.zl.model;

import org.hibernate.validator.constraints.Length;

/**
 * Created by lei_b on 2017/1/24.
 */
public class CommentForm {

    @Length(max = 255)
    private String comment;

    private String article_id;

    private String user_id;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
