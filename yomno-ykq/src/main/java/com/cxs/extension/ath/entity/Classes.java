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
@Table(name = "ath_class", schema = "")
public class Classes implements Serializable {

    private static final long serialVersionUID = 4596202023786387963L;
    /**id*/
    @Id
    @Column(name ="id",nullable=false)
    private String id;
    /**班级名称*/
    @Column(name ="class_name",nullable=false)
    private String className;
    /**学院*/
    @ManyToOne
    @JoinColumn(name="academy_id",referencedColumnName = "id",nullable = false)
    private Academy academy;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Academy getAcademy() {
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
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
