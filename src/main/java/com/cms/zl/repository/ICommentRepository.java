package com.cms.zl.repository;

import com.cms.zl.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lei_b on 2017/1/28.
 */
public interface ICommentRepository extends JpaRepository<Comment, String> {
}
