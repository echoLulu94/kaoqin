package com.cxs.extension.ath.entity;

import javax.persistence.*;
import java.io.Serializable;


/**
 *
 * @Description: 课程表实体类
 * @ClassName: User
 * @author: huimin.wu
 * @email: huimin.wu@iyomoo.com
 * @date: 2018年02月06日
 */
@Entity
@Table(name = "ath_course", schema = "")
public class Course  implements Serializable {
    private static final long serialVersionUID = 8861470073780920076L;

    /**课程id*/
    @Id
    @Column(name ="id",nullable=false)
    private String id;
    /**班级名称*/
    @Column(name ="course_name",nullable=false)
    private String courseName;
    /**用户id*/
    @ManyToOne
    @JoinColumn(name = "user_id" ,referencedColumnName = "id" ,nullable = false)
    private User user;
    /**课程时间*/
    @Column(name="course_time",nullable = false)
    private Long courseTime;
    /**课程节次*/
    @Column(name="course_order",nullable = false)
    private Integer courseOrder;
    /**课程地点*/
    @Column(name="course_location",nullable = false)
    private String courseLocation;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(Long courseTime) {
        this.courseTime = courseTime;
    }

    public Integer getCourseOrder() {
        return courseOrder;
    }

    public void setCourseOrder(Integer courseOrder) {
        this.courseOrder = courseOrder;
    }

    public String getCourseLocation() {
        return courseLocation;
    }

    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
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
