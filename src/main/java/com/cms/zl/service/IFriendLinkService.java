package com.cms.zl.service;

import com.cms.zl.entity.FriendLink;
import org.springframework.data.domain.Page;

/**
 * Created by Vincent on 2017/3/8.
 */
public interface IFriendLinkService {
    FriendLink create(String sname, String site);

    FriendLink get(String id);

    void update(FriendLink flink);

    void delete(String id);

    Page<FriendLink> get(int page, int size);
}
