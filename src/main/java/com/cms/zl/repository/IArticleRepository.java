package com.cms.zl.repository;

import com.cms.zl.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Vincent on 2017/1/1.
 */

public interface IArticleRepository extends JpaRepository<Article, String>{
    Page<Article> findByKind(String kind, Pageable pageable);

    Article findByIdAndKind(String id, String kind);

    List<Article> findByUpdateTimeLessThanOrderByUpdateTimeDesc(Timestamp updateTime);

    List<Article> findByUpdateTimeGreaterThanOrderByUpdateTimeAsc(Timestamp updateTime);

    List<Article> findByKindAndUpdateTimeLessThanOrderByUpdateTimeDesc(String kind, Timestamp updateTime);

    List<Article> findByKindAndUpdateTimeGreaterThanOrderByUpdateTimeAsc(String kind, Timestamp updateTime);
}
