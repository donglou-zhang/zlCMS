package com.cms.zl.service.impl;

import com.cms.zl.entity.Profile;
import com.cms.zl.repository.IProfileRepository;
import com.cms.zl.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Vincent on 2017/1/4.
 */
@Service
@Transactional
public class ProfileServiceImpl implements IProfileService {
    private final IProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(IProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }
    @Override
    public Profile create(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile get(int id) {
        return profileRepository.findOne(id);
    }

    @Override
    public void update(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public void delete(int id) {
        profileRepository.delete(id);
    }
}
