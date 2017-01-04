package com.cms.zl.repository;

import com.cms.zl.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vincent on 2017/1/1.
 */

public interface IArticleRepository extends JpaRepository<Article, String>{
    Page<Article> findByKind(String kind, Pageable pageable);
}
