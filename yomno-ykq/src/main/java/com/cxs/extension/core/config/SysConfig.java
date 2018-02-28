package com.cxs.extension.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @ClassName: AdminConfiguration 
 * @Description: 后台管理系统配置文件类
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年3月7日 下午4:17:38 
 *
 */
@Configuration
public class SysConfig {
    @Value("${extension.protocol}")
    private String protocol;
    @Value("${extension.domain}")
    private String domain;
    @Value("${extension.port}")
    private String port;
    @Value("${extension.contentPath}")
    private String contentPath;
    @Value("${extension.baseUrlKeyName}")
    private String baseUrlKeyName;
    @Value("${extension.tokenName}")
    private String tokenName;
    @Value("${extension.allowOrigin}")
    private String allowOrigin;
    @Value("${extension.resStartSheetIndex}")
    private Integer resStartSheetIndex;
    @Value("${extension.resStartRowIndex}")
    private Integer resStartRowIndex;
    @Value("${extension.staticBaseUrl}")
    private String staticBaseUrl;
    @Value("${extension.staticBasePath}")
    private String staticBasePath;


	@Value("${extension.staticRelativeUrl}")
	private String staticRelativeUrl;
	@Value("${extension.staticLocation}")
	private String staticLocation;


	
	public String getDomain() {
		return domain;
	}

	public String getProtocol() {
		return protocol;
	}

	public String getPort() {
		return port;
	}

	public String getContentPath() {
		return contentPath;
	}

	public String getBaseUrlKeyName() {
		return baseUrlKeyName;
	}

	public String getTokenName() {
		return tokenName;
	}

	public String getAllowOrigin() {
		return allowOrigin;
	}

	public Integer getResStartSheetIndex() {
		return resStartSheetIndex;
	}

	public Integer getResStartRowIndex() {
		return resStartRowIndex;
	}

	public String getStaticBaseUrl() {
		return staticBaseUrl;
	}

	public String getStaticBasePath() {
		return staticBasePath;
	}

	public String getStaticRelativeUrl() {
		return staticRelativeUrl;
	}

	public String getStaticLocation() {
		return staticLocation;
	}
	
}
