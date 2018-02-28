package com.cxs.extension.core.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SysConfig sysConfig;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	logger.debug("静态文件URL:["+sysConfig.getStaticRelativeUrl()+"],静态文件路径:["+sysConfig.getStaticLocation()+"]");
        registry.addResourceHandler(sysConfig.getStaticRelativeUrl()).addResourceLocations(sysConfig.getStaticLocation());
        super.addResourceHandlers(registry);
    }

}