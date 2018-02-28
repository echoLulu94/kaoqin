package com.cxs.framework.utils;

/**
 * 
 * @Description: 类工具类
 * @ClassName: ClassUtils 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年5月13日 上午8:36:56 
 *
 */
public abstract class ClassUtil {

    /**
     * 确定class是否可以被加载
     * @param className 完整类名
     * @param classLoader 类加载
     * @return {boolean}
     */
    public static boolean isPresent(String className, ClassLoader classLoader) {
        try {
            Class.forName(className, true, classLoader);
            return true;
        }
        catch (Throwable ex) {
            // Class or one of its dependencies is not present...
            return false;
        }
    }

}
