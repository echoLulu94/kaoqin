package com.cxs.extension.act.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * @Description: 活动实体类
 * @ClassName: Activity
 * @author: huimin.wu
 * @email: huimin.wu@iyomoo.com
 * @date: 2018年02月06日
 */



@Entity
@Table(name = "mak_activity", schema = "")
public class Activity implements Serializable {

    private static final long serialVersionUID = -2055035853357901801L;

    /**id*/
    @Id
    @Column(name ="id",nullable=false)
    private String id;
    /**用户id*/
    @Column(name ="user_id",nullable=true)
    private String userId;
    /**活动标题*/
    @Column(name ="title",nullable=true)
    private String title;
    /**考勤员姓名*/
    @Column(name ="worker_man",nullable=true)
    private String workerMan;
    /**活动简介*/
    @Column(name ="introduction",nullable=true)
    private String introduction;
    /**主办方*/
    @Column(name ="sponsor",nullable=true)
    private String sponsor;
    /**报名截止时间*/
    @Column(name ="sign_up_deadline",nullable=true)
    private String signUpDeadline;
    /**活动状态*/
    @Column(name ="activity_state",nullable=true)
    private String activityState;
    /**活动开始时间*/
    @Column(name ="start_time",nullable=true)
    private String startTime;
    /**活动结束时间*/
    @Column(name ="end_time",nullable=true)
    private String endTime;
    /**活动类型*/
    @Column(name ="act_type",nullable=true)
    private String actType;
    /**所属平台*/
    @Column(name ="platform",nullable=true)
    private String platform;
    /**会场区域*/
    @Column(name ="meet_area",nullable=true)
    private String meetArea;
    /**活动地点*/
    @Column(name ="place",nullable=true)
    private String place;
    /**参加人数*/
    @Column(name ="participantCount",nullable=true)
    private int participantCount;
    /**剩余可报名人数*/
    @Column(name ="place",nullable=true)
    private String participant_remain_count;
    /**咨询电话*/
    @Column(name ="cust_phone",nullable=true)
    private String custPhone;
    /**是否通知:0-通知;1-不通知*/
    @Column(name ="is_notice",nullable=true)
    private String isNotice;
    /**报名费用*/
    @Column(name ="sign_up_fee",nullable=true)
    private int signUpFee;
    /**活动连接*/
    @Column(name ="activity_url",nullable=true)
    private String activityUrl;
    /**活动状态值*/
    @Column(name ="activity_url",nullable=true)
    private String state;
    /**创建者ID*/
    @Column(name ="create_by",nullable=true)
    private String createBy;
    /**创建时间*/
    @Column(name ="create_time",nullable=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh",timezone = "GMT+8")
    private Long createTime;
    /**修改者id*/
    @Column(name ="update_by",nullable=true)
    private String updateBy;
    /**最后修改时间*/
    @Column(name ="update_time",nullable=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh",timezone = "GMT+8")
    private Long updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWorkerMan() {
        return workerMan;
    }

    public void setWorkerMan(String workerMan) {
        this.workerMan = workerMan;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getSignUpDeadline() {
        return signUpDeadline;
    }

    public void setSignUpDeadline(String signUpDeadline) {
        this.signUpDeadline = signUpDeadline;
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

    public String getActType() {
        return actType;
    }

    public void setActType(String actType) {
        this.actType = actType;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getMeetArea() {
        return meetArea;
    }

    public void setMeetArea(String meetArea) {
        this.meetArea = meetArea;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getParticipantCount() {
        return participantCount;
    }

    public void setParticipantCount(int participantCount) {
        this.participantCount = participantCount;
    }

    public String getParticipant_remain_count() {
        return participant_remain_count;
    }

    public void setParticipant_remain_count(String participant_remain_count) {
        this.participant_remain_count = participant_remain_count;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getIsNotice() {
        return isNotice;
    }

    public void setIsNotice(String isNotice) {
        this.isNotice = isNotice;
    }

    public int getSignUpFee() {
        return signUpFee;
    }

    public void setSignUpFee(int signUpFee) {
        this.signUpFee = signUpFee;
    }

    public String getActivityUrl() {
        return activityUrl;
    }

    public String getActivityState() {
        return activityState;
    }

    public void setActivityState(String activityState) {
        this.activityState = activityState;
    }

    public void setActivityUrl(String activityUrl) {
        this.activityUrl = activityUrl;

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
