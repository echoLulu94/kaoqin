package com.cxs.extension.ath.service.impl;

import com.cxs.extension.ath.mapper.BannerMapper;
import com.cxs.extension.ath.mapper.NewsMapper;
import com.cxs.extension.ath.mapper.NotifyMapper;
import com.cxs.extension.ath.service.api.BasicService;
import com.cxs.framework.dto.ResultDo;
import com.cxs.framework.result.InterfaceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class BasicServiceImpl implements BasicService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BannerMapper bannerMapper;
    @Autowired
    private NotifyMapper notifyMapper;
    @Autowired
    private NewsMapper newsMapper;
    @Override
    public ResultDo<Map<String, Object>> GetBasic() {
        ResultDo<Map<String, Object>> resultDo = new ResultDo<Map<String, Object>>();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try{
            resultMap.put("newsList",newsMapper.selectAll());
            resultMap.put("bannerList",bannerMapper.selectAll());
            resultMap.put("notifyList",notifyMapper.selectAll());
            resultDo.setResultDo(InterfaceResult.SUCCESS);
            logger.info(InterfaceResult.SUCCESS.getValue());
        }catch (Exception e){
            resultDo.setResultDo(InterfaceResult.FIND_FAILURE);
            logger.error(InterfaceResult.FIND_FAILURE.getValue(), e);
        }

        resultDo.setResultData(resultMap);


        return resultDo;
    }
}
