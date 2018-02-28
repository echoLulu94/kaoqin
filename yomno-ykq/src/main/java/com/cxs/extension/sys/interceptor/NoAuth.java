package com.cxs.extension.sys.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: Login 
 * @Description: TODO
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年3月7日 下午4:17:23 
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoAuth {
}
