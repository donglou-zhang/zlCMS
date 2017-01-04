package com.cms.zl.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by Vincent on 2016/12/23.
 */
public class BasedUserDetailsImpl extends User {

    private String id;

    public BasedUserDetailsImpl(String id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString() {
        return "User: " + this.id;
    }
}
