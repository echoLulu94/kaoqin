package com.cxs.extension.ath.mapper;

import com.cxs.extension.ath.entity.News;
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
public interface NewsMapper extends CoreMapper<News> {


    @Select("select * from ath_news")
    @Results({
            @Result(column = "news_title",property = "newsTitle",javaType = String.class),
            @Result(column = "news_url",property = "newsUrl",javaType = String.class)
    })
   List<News> findNews();

}
