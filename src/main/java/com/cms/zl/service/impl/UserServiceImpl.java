package com.cms.zl.service.impl;

import com.cms.zl.entity.User;
import com.cms.zl.repository.IUserRepository;
import com.cms.zl.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Vincent on 2016/12/15.
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService{

    private final IUserRepository userRepository;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(String username, String password) {
        return userRepository.save(new User(username, password));
    }

    public User get(String id) {
        return userRepository.getOne(id);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public void delete(String id) {
        userRepository.delete(id);
    }

    public Page<User> get(int page, int size) {
        PageRequest request = new PageRequest(page, size, Sort.Direction.DESC, "createTime");
        return userRepository.findAll(request);
    }
}
