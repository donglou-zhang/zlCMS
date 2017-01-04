package com.cms.zl.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Vincent on 2016/12/19.
 * * 所有Entity类的基类
 * 提供ID，创建和更新的时间戳
 * <p/>
 * ID为数据库指定
 * 时间戳会在创建和更新之前自动调用相关函数，自动维护
 */
@MappedSuperclass
public class ParentEntity {
    @Id
    @GeneratedValue(generator = "setUUID")
    @GenericGenerator(name = "setUUID", strategy = "uuid")
    @Column(length = 32)
    private String id;

    @Column(nullable = false)
    private Timestamp updateTime;

    @Column(nullable = false)
    private Timestamp createTime;

    public String getId() {
        return id;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    /**
     * 在对实体数据进行数据库更新操作之前，调用该回调方法
     */
    @PreUpdate
    public void preUpdate() {
        updateTime = new Timestamp(System.currentTimeMillis());
    }

    /**
     * 在执行给定实体的相应 EntityManager 持久操作之前，调用该回调方法
     */
    @PrePersist
    public void prePersist() {
        createTime = new Timestamp(System.currentTimeMillis());
        updateTime = createTime;
    }
}
