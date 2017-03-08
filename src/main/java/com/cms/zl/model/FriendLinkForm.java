package com.cms.zl.model;

import org.hibernate.validator.constraints.Length;

/**
 * Created by Vincent on 2017/3/8.
 */
public class FriendLinkForm {

    @Length(max = 64)
    private String sname;

    @Length(min = 1)
    private String site;

    public String getSname() {
        return sname;
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
