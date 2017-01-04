package com.cms.zl.repository;

import com.cms.zl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vincent on 2016/12/15.
 */
public interface IUserRepository extends JpaRepository<User, String>{
    User findByUsername(String username);
}
