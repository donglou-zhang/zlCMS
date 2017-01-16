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
    public Article create(String title, String kind, String content) {
        return articleRepository.save(new Article(title, kind, content));
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
    public Page<Article> getByKind(int page, int size, String kind) {
        return articleRepository.findByKind(kind, new PageRequest(page, size, Sort.Direction.DESC, "updateTime"));
    }

    public Page<Article> get(int page, int size) {
        return articleRepository.findAll(new PageRequest(page, size, Sort.Direction.DESC, "updateTime"));
    }
}
