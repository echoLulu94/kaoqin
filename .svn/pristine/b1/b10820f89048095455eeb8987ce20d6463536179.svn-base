package com.cxs.extension.ath.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ath_term",schema = "")
public class Term  implements Serializable {

    private static final long serialVersionUID = -7897566252014568060L;
    /**id*/
    @Id
    @Column(name = "id",nullable = false)
    private String id;
    /**学期名称*/
    @Column(name="term_name",nullable = true)
    private Long termName;
    /**学期开始时间*/
    @Column(name="start_time",nullable = true)

    private String  startTime;
    /**学期结束时间*/
    @Column(name="end_time",nullable = true)
    private String endTime;
    @Column(name="week",nullable = true)
    private Integer week;
    /**创建者ID*/
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

    public Long getTermName() {
        return termName;
    }

    public void setTermName(Long termName) {
        this.termName = termName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
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
