package com.cxs.extension.ath.mapper;

import com.cxs.extension.ath.entity.Banner;
import com.cxs.extension.ath.entity.Notify;
import com.cxs.extension.core.utils.CoreMapper;
import com.cxs.framework.dto.ResultDo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: shylqian
 * @Description:
 * @Date: created on 下午11:33 18/3/5
 */
@Repository
public interface NotifyMapper extends CoreMapper<Notify> {


    @Select("select * from ath_notify")
    @Results({
            @Result(column = "notify_title",property = "notifyTitle")
    })
  List<Notify>  findNotify();


}
