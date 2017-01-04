package com.cms.zl.model;

import org.hibernate.validator.constraints.Length;

/**
 * Created by Vincent on 2016/12/23.
 */
public class UserSignupForm {

    @Length(min = 2, max = 32)
    public String username;

    @Length(min = 6, max = 64)
    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
