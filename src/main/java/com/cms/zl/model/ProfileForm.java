package com.cms.zl.model;

import org.hibernate.validator.constraints.Length;

/**
 * Created by lei_b on 2017/1/11.
 */
public class ProfileForm {

    @Length(max = 255)
    private String avatar;

    @Length(max = 64)
    private String education;

    @Length(max = 128)
    private String email;

    @Length(max = 255)
    private String label;

    @Length(max = 64)
    private String native_place;

    @Length(max = 64)
    private String studies;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getNative_place() {
        return native_place;
    }

    public void setNative_place(String native_place) {
        this.native_place = native_place;
    }

    public String getStudies() {
        return studies;
    }

    public void setStudies(String studies) {
        this.studies = studies;
    }
}
