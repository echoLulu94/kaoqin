package com.cxs.extension.sys.interceptor;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cxs.extension.core.utils.SpringContextUtil;
/**
 * 
 * @Description: 拦截器配置类，按顺序配置所有的拦截器
 * @ClassName: AuthIntercepterConfigurer 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年5月19日 上午9:42:05 
 *
 */
@Configuration
public class AuthIntercepterConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowCredentials(true)
				.allowedMethods("GET", "POST", "DELETE", "PUT").maxAge(3600);
	}
	
	
	/**
	 * 配置错误页面
	 * 
	 * @return
	 */
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
				ErrorPage errorNotFound = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
				configurableEmbeddedServletContainer.addErrorPages(errorNotFound);
			}
		};
	}

	/**
	 * 定义ApplicationContext工具bean
	 * @return
	 */
	@Bean(name = "springContextUtil")
	public SpringContextUtil springContextUtil() {
		return new SpringContextUtil();
	}

	/**
	 * 定义拦截器bean
	 * @return
	 */
	@Bean
	public AuthInterceptor authInterceptor() {
		return new AuthInterceptor();
	}

	/**
	 * 定义拦截器bean
	 * @return
	 */
	@Bean
	public CorsInterceptor corsInterceptor() {
		return new CorsInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 配置跨域拦截器
		 */
		registry.addInterceptor(corsInterceptor()).addPathPatterns("/**");
		/**
		 * 配置令牌校验拦截器
		 */
		registry.addInterceptor(authInterceptor()).addPathPatterns("/**");
		
		super.addInterceptors(registry);
	}
}
