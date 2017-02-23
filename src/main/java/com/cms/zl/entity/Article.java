package com.cms.zl.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.htmlparser.jericho.Segment;
import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.TextExtractor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vincent on 2016/12/25.
 */
@Entity
public class Article extends ParentEntity{
    @Column(nullable = false)
    private String title;

    @Column
    private String kind;

    @Column
    private String topic;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String summary;

    /*
    * *mappedBy: 定义类之间的双向关系,该属性的值是“多”方class里的“一”方的变量名
    * *fetch: FetchType.EAGER表示关系类在主类加载的时候同时加载；FetchType.LAZY表示关系类在被访问时才加载
    * *cascade:该属性定义类和类之间的级联关系，CascadeType.REMOVE表示级联删除
    * *@JsonIgnore 避免取JSON对象时无限递归的问题，过滤掉一些不需要的属性
     */
    @JsonIgnore
    @OneToMany(mappedBy = "article", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    private Set<Comment> comments;

    public Article() {
        comments = new HashSet<>();
    }

    public Article(String title, String topic, String kind, String content) {
        this.title = title;
        this.kind = kind;
        this.topic = topic;
        this.content = content;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @PreUpdate
    public void preUpdate() {
        super.preUpdate();
        createSummary();
    }

    @PrePersist
    public void prePersist() {
        super.prePersist();
        createSummary();
    }

    private void createSummary() {
        String summary = this.getContent();
        Source source = new Source(summary);

        //提取content中的正文（不包含标签）
        Segment segment = new Segment(source, 0, summary.length()-1);
        TextExtractor textExtractor = new TextExtractor(segment);
        summary = textExtractor.toString();
        if(summary.length() > 200) summary = summary.substring(0, 200) + "......";
        this.setSummary(summary);
    }
}
