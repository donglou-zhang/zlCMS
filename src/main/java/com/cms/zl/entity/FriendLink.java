package com.cms.zl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Vincent on 2017/3/8.
 */
@Entity
public class FriendLink extends ParentEntity {
    @Column
    private String sname;

    @Column(nullable = false)
    private String site;

    public String getSname() {
        return sname;
    }

    public FriendLink(String sname, String site) {
        this.sname = sname;
        this.site = site;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
