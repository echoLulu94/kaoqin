package com.cxs.extension.sys.interceptor;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cxs.extension.core.config.SysConfig;
import com.cxs.extension.core.utils.SpringContextUtil;
import com.cxs.framework.utils.StringUtil;

/**
 * 
 * @ClassName: CorsInterceptor
 * @Description: 跨域拦截器，放在所有拦截器最前端
 * @author: ryan.guo
 * @email: chinazan@qq.com
 * @date: 2017年3月7日 下午4:35:57
 *
 */
public class CorsInterceptor implements HandlerInterceptor {

	private final Logger logger = LoggerFactory.getLogger(CorsInterceptor.class);

	private SysConfig sysConfig;

	@Autowired
	private SpringContextUtil springContnextUtil;

	@PostConstruct
	public void init() {
		sysConfig = springContnextUtil.getBean(SysConfig.class);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
		if (o instanceof HandlerMethod) {
			return dealSelfSiteHandle(request, response, o);
		} else {
			return true;
		}
	}

	/**
	 * 处理跨域请求
	 */
	private boolean dealSelfSiteHandle(HttpServletRequest request, HttpServletResponse response, Object o)
			throws Exception {
		response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		logger.info("设置跨域处理！");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
