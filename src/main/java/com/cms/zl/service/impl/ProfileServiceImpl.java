package com.cms.zl.service.impl;

import com.cms.zl.entity.Profile;
import com.cms.zl.service.IProfileService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Vincent on 2017/1/4.
 */
@Service
@Transactional
public class ProfileServiceImpl implements IProfileService {
    //TODO
    @Override
    public Profile create(Profile profile) {
        return null;
    }

    @Override
    public Profile get(int id) {
        return null;
    }

    @Override
    public void update(Profile profile) {

    }

    @Override
    public void delete(int id) {

    }
}
