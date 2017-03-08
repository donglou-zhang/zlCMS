package com.cms.zl.service.impl;

import com.cms.zl.entity.FriendLink;
import com.cms.zl.repository.IFriendLinkRepository;
import com.cms.zl.service.IFriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Vincent on 2017/3/8.
 * @Transactional声明这个service所有方法需要事务管理
 */
@Service
@Transactional
public class FriendLinkServiceImpl implements IFriendLinkService {
    private final IFriendLinkRepository friendLinkRepository;

    @Autowired
    FriendLinkServiceImpl(IFriendLinkRepository friendLinkRepository) {
        this.friendLinkRepository = friendLinkRepository;
    }

    @Override
    public FriendLink create(String sname, String site) {
        return friendLinkRepository.save(new FriendLink(sname, site));
    }

    @Override
    public FriendLink get(String id) {
        return friendLinkRepository.findOne(id);
    }

    @Override
    public void update(FriendLink flink) {
        friendLinkRepository.save(flink);
    }

    @Override
    public void delete(String id) {
        friendLinkRepository.delete(id);
    }

    @Override
    public Page<FriendLink> get(int page, int size) {
        PageRequest request = new PageRequest(page, size, Sort.Direction.DESC, "updateTime");
        return friendLinkRepository.findAll(request);
    }
}
