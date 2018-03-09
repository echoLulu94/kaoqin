package com.cxs.extension.sys.interceptor;

import java.io.Writer;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cxs.extension.ath.dto.UserDto;
import com.cxs.extension.ath.result.UserResult;
import com.cxs.extension.ath.service.api.UserService;
import com.cxs.extension.core.config.SysConfig;
import com.cxs.extension.core.utils.SpringContextUtil;
import com.cxs.framework.dto.ResultDo;
import com.cxs.framework.result.InterfaceResult;
import com.cxs.framework.utils.StringUtil;
import com.cxs.framework.utils.ath.Token;

/**
 * 
 * @ClassName: AuthInterceptor
 * @Description: 令牌校验拦截器
 * @author: ryan.guo
 * @email: chinazan@qq.com
 * @date: 2017年3月7日 下午4:35:57
 *
 */
public class AuthInterceptor implements HandlerInterceptor {

	private final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

	private SysConfig sysConfig;

	@Autowired
	private SpringContextUtil springContnextUtil;
	
	@Autowired
	private UserService userService;

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
	 * 由于跨域请求得到的obj不相同，所以该类用于处理非跨域的请求
	 *
	 * @param request
	 * @param response
	 * @param o
	 * @return
	 * @throws Exception
	 */
	private boolean dealSelfSiteHandle(HttpServletRequest request, HttpServletResponse response, Object o)
			throws Exception {
		HandlerMethod method = (HandlerMethod) o;
		NoAuth noAuth = method.getMethodAnnotation(NoAuth.class);
		ResultDo<String> resultDo = new ResultDo<String>();
		logger.info("sessionId:["+request.getSession().getId()+"]");

		// 令牌校验是否正常
		Boolean flag = false;
		logger.info("请求:["+request.getRequestURL()+"]");
		if (noAuth == null) {
			Token token = Token.readTokenFromCookie(sysConfig.getTokenName(),request.getCookies());
			// 判断Cookie是否有令牌
			if (null != token) {
				if(StringUtil.isEmpty(token.getId())){
					// token无效
					resultDo.setResultDo(UserResult.LOGIN_TOKEN_PHONE_IS_NULL);
					logger.info(UserResult.LOGIN_TOKEN_PHONE_IS_NULL.getValue()+"用户学号:["+token.getId()+"]");
				}else{
					UserDto userDto = userService.findByPhone(token.getId());
					if(null!=userDto){
						request.setAttribute("userId", userDto.getId());
						logger.debug("登录用户的id:["+userDto.getId()+"]");
						String salt = userDto.getSalt();
						logger.debug("令牌中的登陆用户名:["+token.getId()+"]");
						// 验证token是否有效
						if(Token.isTokenLegal(token, salt)){
							// token有效
							flag=true;
						}else{
							// token无效
							resultDo.setResultDo(UserResult.LOGIN_TOKEN_ERROR);
							logger.info(UserResult.LOGIN_TOKEN_ERROR.getValue()+"用户名:["+token.getId()+"]");
						}
					}else{
						// token无效
						resultDo.setResultDo(UserResult.LOGIN_TOKEN_ERROR);
						logger.info(UserResult.LOGIN_TOKEN_ERROR.getValue()+"用户名:["+token.getId()+"]");
					}
				}
			} else {
				// Cookie中无令牌,用户未登录或登录态失效
				resultDo.setResultDo(UserResult.LOGIN_TOKEN_INVALID);
				logger.info(UserResult.LOGIN_TOKEN_INVALID.getValue());
			}
		}else{
			logger.info("无需鉴权的请求!");
			flag=true;
		}
		if (!flag) {
			// 鉴权失败
			authFailure(request,response,resultDo);
		}
		return flag;
	}

	/**
	 * 鉴权失败处理
	 * 
	 * @param request 
	 * @return
	 * @throws Exception 
	 */
	private void authFailure(HttpServletRequest request,HttpServletResponse response,ResultDo<String> resultDo) throws Exception {
//		if((request.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()))){
//			//ajax请求返回失败结果
//			logger.info("ajax请求!");
//			writeUserNoLogin(response,resultDo);
//		}else{
//			//非ajax请求重定向到登陆
//			logger.info("非ajax传统请求!");
//		}
		writeUserNoLogin(response,resultDo);
	}
	
	
	/**
	 * ajax用户未登录返回json串
	 * 
	 * @param response
	 * @throws Exception
	 */
	private void writeUserNoLogin(HttpServletResponse response,ResultDo<String> resultDo) throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		Writer writer = response.getWriter();
		JSONObject jsonObject = (JSONObject) JSONObject.toJSON(resultDo);
		writer.write(jsonObject.toString());
		writer.close();
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o,
			ModelAndView modelAndView) throws Exception {
		if (modelAndView != null) {
			// 添加系统常量
			configCommonSiteParam(modelAndView, request, response);
		}
	}

	/**
	 * 添加系统常量
	 * 
	 * @param mav
	 * @param request
	 * @param response
	 */
	public void configCommonSiteParam(ModelAndView mav, HttpServletRequest request, HttpServletResponse response) {
		StringBuilder baseUrlBuilder = new StringBuilder();
		baseUrlBuilder.append(sysConfig.getProtocol()).append("://").append(sysConfig.getDomain());
		/**
		 * 添加端口
		 */
		if (StringUtil.isNotEmpty(sysConfig.getPort()) && !"80".equals(sysConfig.getPort())) {
			/**
			 * 非空或非80端口，追加端口
			 */
			baseUrlBuilder.append(":").append(sysConfig.getPort());
		}
		if (StringUtil.isNotEmpty(sysConfig.getContentPath())) {
			baseUrlBuilder.append("/").append(sysConfig.getContentPath());
		}
		mav.addObject(sysConfig.getBaseUrlKeyName(), baseUrlBuilder.toString());
	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

	}

}
