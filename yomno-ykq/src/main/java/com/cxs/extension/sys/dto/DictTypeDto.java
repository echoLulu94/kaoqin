package com.cxs.extension.sys.dto;

import java.io.Serializable;
/**
 * 
 * @Description: 字典类型数据对象
 * @ClassName: DictTypeDto
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年06月12日
 */
public class DictTypeDto implements Serializable{
	private static final long serialVersionUID = 1L;
	/**id*/
	private String id;
	/**字典类型编码*/
	private String typeCode;
	/**字典类型名称*/
	private String typeName;
	/**状态:0-不可用;1-可用*/
	private String state;
	/**备注*/
	private String typeDes;
	/**创建时间*/
	private Long createTime;
	/**更新时间*/
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
	 *方法: 取得字典类型编码
	 *@return: String  字典类型编码
	 */
	public String getTypeCode(){
		return this.typeCode;
	}

	/**
	 *方法: 设置字典类型编码
	 *@param: String  字典类型编码
	 */
	public void setTypeCode(String typeCode){
		this.typeCode = typeCode;
	}
	
	/**
	 *方法: 取得字典类型名称
	 *@return: String  字典类型名称
	 */
	public String getTypeName(){
		return this.typeName;
	}

	/**
	 *方法: 设置字典类型名称
	 *@param: String  字典类型名称
	 */
	public void setTypeName(String typeName){
		this.typeName = typeName;
	}
	
	/**
	 *方法: 取得状态:0-不可用;1-可用
	 *@return: String  状态:0-不可用;1-可用
	 */
	public String getState(){
		return this.state;
	}

	/**
	 *方法: 设置状态:0-不可用;1-可用
	 *@param: String  状态:0-不可用;1-可用
	 */
	public void setState(String state){
		this.state = state;
	}
	
	/**
	 *方法: 取得备注
	 *@return: String  备注
	 */
	public String getTypeDes(){
		return this.typeDes;
	}

	/**
	 *方法: 设置备注
	 *@param: String  备注
	 */
	public void setTypeDes(String typeDes){
		this.typeDes = typeDes;
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
	 *方法: 取得更新时间
	 *@return: Long  更新时间
	 */
	public Long getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置更新时间
	 *@param: Long  更新时间
	 */
	public void setUpdateTime(Long updateTime){
		this.updateTime = updateTime;
	}
}
