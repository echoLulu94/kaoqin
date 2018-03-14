package com.cxs.extension.ath.service.impl;

import com.cxs.extension.ath.entity.Course;
import com.cxs.extension.ath.mapper.CourseMapper;
import com.cxs.extension.ath.result.CourseResult;
import com.cxs.extension.ath.service.api.CourseService;
import com.cxs.framework.dto.ResultDo;
import com.cxs.framework.result.InterfaceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public ResultDo<Map<String,Object>> findCourseList(String classId, Long startTime, Long endTime) {
        ResultDo<Map<String, Object>> resultDo = new ResultDo<Map<String, Object>>();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<Course> courseList=new ArrayList<>();
        /*classId="0508201";
        startTime=(long)20170801;
        endTime=(long)20170912;*/
        if(classId!=null&&startTime!=null&&endTime!=null&&!"".equals(classId)){
            courseList= courseMapper.findCourseDetail(classId,startTime,endTime);
            logger.info(courseList.toString());
            if(courseList!=null){
                resultDo.setResultDo(InterfaceResult.SUCCESS);
                logger.info(InterfaceResult.SUCCESS.getValue());
            }else{
                resultDo.setResultDo(CourseResult.FIND_FAILURE);
                logger.info(CourseResult.FIND_FAILURE.getValue());
            }
        }else{
            resultDo.setResultDo(CourseResult.FIND_NOT_NULL);
            logger.info(CourseResult.FIND_NOT_NULL.getValue());
        }
        resultMap.put("courseList",courseList);
        resultDo.setResultData(resultMap);
        return resultDo;
    }
}
