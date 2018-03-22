package com.cxs.extension.ath.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @Description: 班级表实体类
 * @ClassName: User
 * @author: huimin.wu
 * @email: huimin.wu@iyomoo.com
 * @date: 2018年02月06日
 */
@Entity
@Table(name = "ath_notify", schema = "")
public class Notify implements Serializable {


    private static final long serialVersionUID = 4596202023786387963L;
    /**id*/
    @Id
    @Column(name ="id",nullable=false)
    private String id;
    /**班级名称*/
    @Column(name ="notify_title",nullable=false)
    private String notifyTitle;
    /**学院*/
    @Column(name="notify_url",nullable = false)
    private String notifyUrl;
    @Column(name ="create_by",nullable=true)
    private String createBy;
    /**创建时间*/
    @Column(name ="create_time",nullable=true)
    private Long createTime;
    /**修改者id*/
    @Column(name ="update_by",nullable=true)
    private String updateBy;
    /**最后修改时间*/
    @Column(name ="update_time",nullable=true)
    private Long updateTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotifyTitle() {
        return notifyTitle;
    }

    public void setNotifyTitle(String notifyTitle) {
        this.notifyTitle = notifyTitle;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
