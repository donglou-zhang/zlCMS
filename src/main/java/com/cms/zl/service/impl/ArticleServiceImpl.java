package com.cms.zl.service.impl;

import com.cms.zl.entity.Article;
import com.cms.zl.repository.IArticleRepository;
import com.cms.zl.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Vincent on 2017/1/1.
 */
@Service
@Transactional
public class ArticleServiceImpl implements IArticleService{
    private final IArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(IArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article create(String title, String topic, String kind, String content) {
        return articleRepository.save(new Article(title, topic, kind, content));
    }

    @Override
    public void delete(String id) {
        articleRepository.delete(id);
    }

    @Override
    public void update(Article article) {
        articleRepository.save(article);
    }

    @Override
    public Article get(String id) {
        return articleRepository.findOne(id);
    }

    @Override
    public Article getByIdAndKind(String id, String kind) {
        return articleRepository.findByIdAndKind(id, kind);
    }

    @Override
    public Article getPreArticle(Timestamp updateTime) {
        List<Article> resultArticles = articleRepository.findByUpdateTimeGreaterThanOrderByUpdateTimeAsc(updateTime);
        if(resultArticles.size() > 0) {
            return resultArticles.get(0);
        }
        else {
            return null;
        }
    }

    @Override
    public Article getNextArticle(Timestamp updateTime) {
        List<Article> resultArticles = articleRepository.findByUpdateTimeLessThanOrderByUpdateTimeDesc(updateTime);
        if(resultArticles.size() > 0) {
            return resultArticles.get(0);
        }
        else {
            return null;
        }
    }

    @Override
    public Article getPreArticleByKind(String kind, Timestamp updateTime) {
        List<Article> resultArticles = articleRepository.findByKindAndUpdateTimeGreaterThanOrderByUpdateTimeAsc(kind, updateTime);
        if(resultArticles.size() > 0) {
            return resultArticles.get(0);
        }
        else {
            return null;
        }
    }

    @Override
    public Article getNextArticleByKind(String kind, Timestamp updateTime) {
        List<Article> resultArticles = articleRepository.findByKindAndUpdateTimeLessThanOrderByUpdateTimeDesc(kind, updateTime);
        if(resultArticles.size() > 0) {
            return resultArticles.get(0);
        }
        else {
            return null;
        }
    }

    @Override
    public Page<Article> getByKind(int page, int size, String kind) {
        return articleRepository.findByKind(kind, new PageRequest(page, size, Sort.Direction.DESC, "updateTime"));
    }

    public Page<Article> get(int page, int size) {
        return articleRepository.findAll(new PageRequest(page, size, Sort.Direction.DESC, "updateTime"));
    }
}
