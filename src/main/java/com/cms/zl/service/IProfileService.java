package com.cms.zl.service;

import com.cms.zl.entity.Profile;

/**
 * Created by Vincent on 2017/1/4.
 */
public interface IProfileService {

    Profile create(Profile profile);

    Profile get(int id);

    void update(Profile profile);

    void delete(int id);
}
