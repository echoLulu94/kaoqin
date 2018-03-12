package com.cxs.extension.ath.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * @Description: 记录表实体类
 * @ClassName: User
 * @author: huimin.wu
 * @email: huimin.wu@iyomoo.com
 * @date: 2018年02月06日
 */
@Entity
@Table(name = "ath_record", schema = "")
public class Record implements Serializable {
    private static final long serialVersionUID = -2504515932628991600L;

    /**
     * 课程id
     */
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    /**
     * 记录类型：10-课堂考勤；11-活动考勤
     */
    @Column(name = "record_type", nullable = false)
    private String recordType;
    /**
     * 考勤状态：10-准点；11-迟到；12-早退；13-请假；14-缺勤
     */
    @Column(name = "record_status", nullable = false)
    private String recordStatus;
    /**
     * 记录时间
     */
    @Column(name = "record_time", nullable = false)
    private Long recordTime;
    /**
     * 创建者ID
     */
    @Column(name = "create_by", nullable = true)
    private String createBy;
    /**
     * 创建时间
     */
    @Column(name = "create_time", nullable = true)
    private Long createTime;
    /**
     * 修改者id
     */
    @Column(name = "update_by", nullable = true)
    private String updateBy;
    /**
     * 最后修改时间
     */
    @Column(name = "update_time", nullable = true)
    private Long updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Long getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Long recordTime) {
        this.recordTime = recordTime;
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



