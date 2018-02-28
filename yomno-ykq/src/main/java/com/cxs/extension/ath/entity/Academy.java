package com.cxs.extension.ath.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * @Description: 学院表实体类
 * @ClassName: Academy
 * @author: huimin.wu
 * @email: huimin.wu@iyomoo.com
 * @date: 2018年02月06日
 */
@Entity
@Table(name = "ath_academy", schema = "")
public class Academy implements Serializable {
    private static final long serialVersionUID = 1339331791933926189L;

    /**id*/
    @Id
    @Column(name ="id",nullable=false)
    private String id;
    /**学院名称*/
    @Column(name ="academy_name",nullable=true)
    private String academyName;
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


    /**
     *方法: 取得id
     *@return: String  id
     */
    public String getId(){
        return this.id;
    }

    /**
     *方法: 设置id
     *@param: String  id
     */
    public void setId(String id){
        this.id = id;
    }

    /**
     *方法: 取得academyName
     *@return: String  academyName
     */
    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }
    /**
     *方法: 取得academyName
     *@return: String  academyName
     */
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    /**
     *方法: 取得创建时间
     *@return: Long  创建时间
     */
    public Long getCreateTime(){
        return this.createTime;
    }

    /**
     *方法: 设置创建时间
     *@param: Long  创建时间
     */
    public void setCreateTime(Long createTime){
        this.createTime = createTime;
    }
    /**
     *方法: 取得academyName
     *@return: String  academyName
     */
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    /**
     *方法: 取得academyName
     *@return: String  academyName
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

}
