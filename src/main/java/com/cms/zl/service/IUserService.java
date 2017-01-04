package com.cms.zl.service;

import com.cms.zl.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Created by Vincent on 2016/12/15.
 */
public interface IUserService {

    User create(String username, String password);

//    @PreAuthorize("hasRole('ROLE_USER') AND hasRole('ROLE_ADMIN')")
    User get(String id);

    void update(User user);

    void delete(String id);

    Page<User> get(int page, int size);

    User getByUsername(String name);
}
