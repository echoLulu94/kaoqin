package com.cxs.extension.ath.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @Description: 用户表实体类
 * @Claauthor: huimin.wu
 * @emssName: User
 * @ail: huimin.wu@iyomoo.com
 * @date: 2018年02月06日
 */
@Entity
@Table(name = "ath_user", schema = "")
public class User implements Serializable{

	private static final long serialVersionUID = -7897566252014568060L;
	/**id*/
	@Id
	@Column(name ="id",nullable=false)
	private String id;
	/**用户编码*/
	@Column(name ="code",nullable=true)
	private String code;
	/**昵称*/
	@Column(name ="nick_name",nullable=true)
	private String nickName;
	/**英文名*/
	@Column(name ="en_name",nullable=true)
	private String enName;	
	/**用户姓名*/
	@Column(name ="real_name",nullable=true)
	private String realName;
	/**类型：10-超级管理员；11-考勤员；12-教师；13-学生*/
	@Column(name ="user_type",nullable=true)
	private String userType;
	/**密码*/
	@Column(name ="pwd",nullable=true)
	private String pwd;
	/**电话*/
	@Column(name ="phone",nullable=true)
	private String phone;
	/**初始密码*/
	@Column(name ="init_pwd",nullable=true)
	private String initPwd;
	/**性别*/
	@Column(name ="sex",nullable=true)
	private String sex;
	/**性别*/
	@Column(name ="idcard",nullable=true)
	private String idcard;
	/**性别*/
	@Column(name ="birthday",nullable=true)
	private String birthday;
	/**性别*/
	@Column(name ="head_img_url",nullable=true)
	private String headImgUrl;
	/**电子邮件*/
	@Column(name ="email",nullable=true)
	private String email;
	/**秘钥*/
	@Column(name ="salt",nullable=true)
	private String salt;
	/**锁定：0-未锁定；1-已锁定；默认0*/
	@Column(name ="locked",nullable=true)
	private String locked;
	/**失败登录次数*/
	@Column(name ="login_fail_count",nullable=true)
	private Integer loginFailCount;
	/**注册时间*/
	@Column(name ="register_time",nullable=true)
	private Long registerTime;
	/**登录时间*/
	@Column(name ="login_time",nullable=true)
	private Long loginTime;
	/**登录渠道:10-pc;11-android;12-ios*/
	@Column(name ="login_channel",nullable=true)
	private String loginChannel;
	/**登录设备id*/
	@Column(name ="login_device_id",nullable=true)
	private String loginDeviceId;
	/**登录ip*/
	@Column(name ="login_ip",nullable=true)
	private String loginIp;
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
	 *方法: 取得昵称
	 *@return: String  昵称
	 */
	public String getNickName(){
		return this.nickName;
	}

	/**
	 *方法: 设置昵称
	 *@param: String  昵称
	 */
	public void setNickName(String nickName){
		this.nickName = nickName;
	}

	/**
	 *方法: 取得英文名
	 *@return: String  英文名
	 */
	public String getEnName(){
		return this.enName;
	}

	/**
	 *方法: 设置英文名
	 *@param: String  英文名
	 */
	public void setEnName(String enName){
		this.enName = enName;
	}

	/**
	 *方法: 取得用户姓名
	 *@return: String  用户姓名
	 */
	public String getRealName(){
		return this.realName;
	}

	/**
	 *方法: 设置用户姓名
	 *@param: String  用户姓名
	 */
	public void setRealName(String realName){
		this.realName = realName;
	}

	/**
	 *方法: 取得类型：10-超级管理员；11-考勤员；12-教师；13-学生
	 *@return: String  类型：10-超级管理员；11-考勤员；12-教师；13-学生
	 */
	public String getUserType(){
		return this.userType;
	}

	/**
	 *方法: 设置类型：10-超级管理员；11-考勤员；12-教师；13-学生
	 *@param: String  类型：10-超级管理员；11-考勤员；12-教师；13-学生
	 */
	public void setUserType(String userType){
		this.userType = userType;
	}

	/**
	 *方法: 取得密码
	 *@return: String  密码
	 */
	public String getPwd(){
		return this.pwd;
	}

	/**
	 *方法: 设置密码
	 *@param: String  密码
	 */
	public void setPwd(String pwd){
		this.pwd = pwd;
	}

	/**
	 *方法: 取得电话
	 *@return: String  电话
	 */
	public String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置电话
	 *@param: String  电话
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}

	/**
	 *方法: 取得电子邮件
	 *@return: String  电子邮件
	 */
	public String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置电子邮件
	 *@param: String  电子邮件
	 */
	public void setEmail(String email){
		this.email = email;
	}

	/**
	 *方法: 取得秘钥
	 *@return: String  秘钥
	 */
	public String getSalt(){
		return this.salt;
	}

	/**
	 *方法: 设置秘钥
	 *@param: String  秘钥
	 */
	public void setSalt(String salt){
		this.salt = salt;
	}

	/**
	 *方法: 取得锁定：0-未锁定；1-已锁定；默认0
	 *@return: String  锁定：0-未锁定；1-已锁定；默认0
	 */
	public String getLocked(){
		return this.locked;
	}

	/**
	 *方法: 设置锁定：0-未锁定；1-已锁定；默认0
	 *@param: String  锁定：0-未锁定；1-已锁定；默认0
	 */
	public void setLocked(String locked){
		this.locked = locked;
	}

	/**
	 *方法: 取得失败登录次数
	 *@return: Integer  失败登录次数
	 */
	public Integer getLoginFailCount(){
		return this.loginFailCount;
	}

	/**
	 *方法: 设置失败登录次数
	 *@param: Integer  失败登录次数
	 */
	public void setLoginFailCount(Integer loginFailCount){
		this.loginFailCount = loginFailCount;
	}

	/**
	 *方法: 取得注册时间
	 *@return: Long  注册时间
	 */
	public Long getRegisterTime(){
		return this.registerTime;
	}

	/**
	 *方法: 设置注册时间
	 *@param: Long  注册时间
	 */
	public void setRegisterTime(Long registerTime){
		this.registerTime = registerTime;
	}

	/**
	 *方法: 取得登录时间
	 *@return: Long  登录时间
	 */
	public Long getLoginTime(){
		return this.loginTime;
	}

	/**
	 *方法: 设置登录时间
	 *@param: Long  登录时间
	 */
	public void setLoginTime(Long loginTime){
		this.loginTime = loginTime;
	}

	/**
	 *方法: 取得登录渠道:10-pc;11-android;12-ios
	 *@return: String  登录渠道:10-pc;11-android;12-ios
	 */
	public String getLoginChannel(){
		return this.loginChannel;
	}

	/**
	 *方法: 设置登录渠道:10-pc;11-android;12-ios
	 *@param: String  登录渠道:10-pc;11-android;12-ios
	 */
	public void setLoginChannel(String loginChannel){
		this.loginChannel = loginChannel;
	}

	/**
	 *方法: 取得登录设备id
	 *@return: String  登录设备id
	 */
	public String getLoginDeviceId(){
		return this.loginDeviceId;
	}

	/**
	 *方法: 设置登录设备id
	 *@param: String  登录设备id
	 */
	public void setLoginDeviceId(String loginDeviceId){
		this.loginDeviceId = loginDeviceId;
	}

	/**
	 *方法: 取得登录ip
	 *@return: String  登录ip
	 */
	public String getLoginIp(){
		return this.loginIp;
	}

	/**
	 *方法: 设置登录ip
	 *@param: String  登录ip
	 */
	public void setLoginIp(String loginIp){
		this.loginIp = loginIp;
	}

	/**
	 *方法: 取得创建者ID
	 *@return: String  创建者ID
	 */
	public String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置创建者ID
	 *@param: String  创建者ID
	 */
	public void setCreateBy(String createBy){
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
	 *方法: 取得修改者id
	 *@return: String  修改者id
	 */
	public String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置修改者id
	 *@param: String  修改者id
	 */
	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}

	/**
	 *方法: 取得最后修改时间
	 *@return: Long  最后修改时间
	 */
	public Long getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置最后修改时间
	 *@param: Long  最后修改时间
	 */
	public void setUpdateTime(Long updateTime){
		this.updateTime = updateTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
    /**
     * 性别
     */

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public String getInitPwd() {
		return initPwd;
	}

	public void setInitPwd(String initPwd) {
		this.initPwd = initPwd;
	}

}
