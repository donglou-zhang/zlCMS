package com.cms.zl.service.impl;

import com.cms.zl.entity.Article;
import com.cms.zl.entity.Comment;
import com.cms.zl.repository.IArticleRepository;
import com.cms.zl.repository.ICommentRepository;
import com.cms.zl.repository.IUserRepository;
import com.cms.zl.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by lei_b on 2017/1/28.
 */
@Service
@Transactional
public class CommentService implements ICommentService {
    private final ICommentRepository commentRepository;
    private final IArticleRepository articleRepository;
    private final IUserRepository userRepository;


    @Autowired
    public CommentService(ICommentRepository commentRepository, IArticleRepository articleRepository, IUserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }
    @Override
    public Comment create(String comment, String article_id, String user_id) {
        return commentRepository.save(new Comment(comment, articleRepository.findOne(article_id), userRepository.findOne(user_id)));
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Comment get(String id) {
        return null;
    }
}
