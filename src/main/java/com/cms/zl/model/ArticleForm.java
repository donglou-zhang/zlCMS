package com.cms.zl.model;

import org.hibernate.validator.constraints.Length;

/**
 * Created by Vincent on 2017/1/1.
 */
public class ArticleForm {
    @Length(min = 1, max = 225)
    private String title;

    @Length(max = 64)
    private String kind;

    @Length(min = 1)
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
