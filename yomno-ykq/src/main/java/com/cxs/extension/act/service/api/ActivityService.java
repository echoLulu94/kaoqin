package com.cxs.extension.act.service.api;


import com.cxs.extension.ath.dto.UserDto;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @Description: 项目业务处理接口定义
 * @ClassName: UserService
 * @author: huimin.wu
 * @email: huimin.wu@iyomoo.com
 * @date: 2018年1月21日
 *
 */
public interface ActivityService {

    /**
     * 累计项目次数
     * @return
     */
    @Select("select count(id) from mak_activity")
    Integer findActivityCount();


}
