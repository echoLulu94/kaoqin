package com.cxs.extension.core.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 
 * @Description: 底层Mapper
 * @ClassName: CoreMapper 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年5月21日 上午8:24:25 
 * 
 * @param <T> 具体的实体类
 */
public interface CoreMapper<T> extends Mapper<T>, MySqlMapper<T> {
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}
