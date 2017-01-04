package com.cms.zl.service;

import com.cms.zl.entity.Article;
import org.springframework.data.domain.Page;

/**
 * Created by Vincent on 2017/1/1.
 */
public interface IArticleService {
    Article create(String title, String kind, String content);

    void delete(String id);

    void update(Article article);

    Article get(String id);

    Page<Article> getByKind(int page, int size, String kind);
}
