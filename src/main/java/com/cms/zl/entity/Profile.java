package com.cms.zl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Vincent on 2017/1/4.
 * 个人资料
 */
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    private int id;

    @Column
    private String avatar;//头像

    @Column(length = 64)
    private String native_place;//籍贯

    @Column(length = 64)
    private String education;//教育

    @Column(length = 128)
    private String email;//邮箱

    @Column
    private String label;//自定义标签（label1&label2）

    @Column(length = 64)
    private String studies;//研究方向

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNative_place() {
        return native_place;
    }

    public void setNative_place(String native_place) {
        this.native_place = native_place;
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

    public String getStudies() {
        return studies;
    }

    public void setStudies(String studies) {
        this.studies = studies;
    }
}
