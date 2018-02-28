package com.cxs.framework.dto;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * @ClassName: ResultDo 
 * @Description: 服务返回对象
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年3月2日 下午3:58:43 
 * 
 * @param <T> 数据对象
 */
public class ResultDo<T> implements Serializable{

	private static final long serialVersionUID = -3434272908589805662L;

	/**
	 * 跳转URL
	 */
//	private String forwardUrl;
	/**
	 * 业务响应码
	 * 取值范围：9位数字加大写字母字符，由具体接口的提供方自定义详细的返回响应码
	 * 格式：子系统编号（3位大写字母）+模块编号（2位10~99）+功能编号（2位10~99）+业务响应编号（2位10~99）
	 * 例如：登录接口的登录成功响应	
	 * 			resultCode： ATH121611	
	 * 				子系统编号：ATH
	 * 				模块编号：12	
	 * 				功能编号：16
	 * 				功能编号：11
	 */
	private String resultCode;
	
	/**
	 * 业务响应描述
	 * 与业务响应码一一对应
	 */
	private String resultMsg;
	
	/**
	 * 返回数据对象
	 * 有数据则返回，无数据返回空
	 */
	private T resultData;

	public ResultDo() {}

	public ResultDo( String resultCode) {
		this.resultCode = resultCode;
	}

	public ResultDo(T resultData) {
		this.resultData = resultData;
	}

	public ResultDo( String resultCode, T resultData) {
		this.resultCode = resultCode;
		this.resultData = resultData;
	}

	/**
	 * 设置响应码、响应描述
	 * @param result 响应对象
	 */
	public void setResultDo(Map.Entry<String, String> result){
		this.resultCode = result.getKey();
		this.resultMsg = result.getValue();
	}

	/**
	 * 设置响应码、响应描述、响应数据对象
	 * @param result 响应对象
	 * @param resultData 响应数据对象
	 */
	public void setResultDo(Map.Entry<String, String> result, T resultData){
		this.resultCode = result.getKey();
		this.resultMsg = result.getValue();
		this.resultData = resultData;
	}

	/**
	 * 设置响应码、响应描述
	 * @param resultCode 响应编码
	 * @param resultMsg 响应描述
	 */
	public void setResultDo(String resultCode, String resultMsg){
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}

	/**
	 * 设置响应码、响应描述、响应数据对象
	 * @param resultCode 响应编码
	 * @param resultMsg 响应描述
	 * @param resultData 响应数据对象
	 */
	public void setResultDo(String resultCode, String resultMsg, T resultData){
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.resultData = resultData;
	}


	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public T getResultData() {
		return resultData;
	}

	public void setResultData(T resultData) {
		this.resultData = resultData;
	}

}
