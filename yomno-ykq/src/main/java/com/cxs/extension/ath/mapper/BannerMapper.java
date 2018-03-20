package com.cxs.extension.ath.mapper;

import com.cxs.extension.ath.entity.Banner;
import com.cxs.extension.core.utils.CoreMapper;
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
public interface BannerMapper extends CoreMapper<Banner> {

    @Select("Select banner_title as bannerTitle,banner_url as bannerUrl from ath_banner")
    @Results({

            @Result(column = "banner_title",property = "bannerTitle"),
            @Result(column = "banner_url",property = "bannerUrl")
    })
   List<Banner>  findBanner();
}
