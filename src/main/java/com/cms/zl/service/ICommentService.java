package com.cms.zl.service;

import com.cms.zl.entity.Comment;

/**
 * Created by lei_b on 2017/1/28.
 */
public interface ICommentService {
    Comment create(String comment, String article_id, String user_id);

    void delete(String id);

    Comment get(String id);
}
