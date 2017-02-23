package com.cms.zl.service;

import com.cms.zl.entity.Article;
import org.springframework.data.domain.Page;

import java.sql.Timestamp;

/**
 * Created by Vincent on 2017/1/1.
 */
public interface IArticleService {
    Article create(String title, String topic, String kind, String content);

    void delete(String id);

    void update(Article article);

    Article get(String id);

    Article getByIdAndKind(String id, String kind);

    Article getPreArticle(Timestamp updateTime);

    Article getNextArticle(Timestamp updateTime);

    Article getPreArticleByKind(String kind, Timestamp updateTime);

    Article getNextArticleByKind(String kind, Timestamp updateTime);

    Page<Article> getByKind(int page, int size, String kind);

    Page<Article> get(int page, int size);
}
