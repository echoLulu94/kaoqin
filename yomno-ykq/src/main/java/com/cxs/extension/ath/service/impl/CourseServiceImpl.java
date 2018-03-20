package com.cxs.extension.ath.service.impl;

import com.cxs.extension.ath.mapper.CourseMapper;
import com.cxs.extension.ath.mapper.TermMapper;
import com.cxs.extension.ath.result.CourseResult;
import com.cxs.extension.ath.service.api.CourseService;
import com.cxs.extension.sys.service.api.DictItemService;
import com.cxs.framework.utils.MondayAndFridayUtil;
import com.cxs.framework.dto.ResultDo;
import com.cxs.framework.result.InterfaceResult;
import com.cxs.framework.utils.DateToWeekUtil;
import com.cxs.framework.utils.WeekToDateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CourseServiceImpl implements CourseService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private TermMapper termMapper;

    @Autowired
    private DictItemService dictItemService;

    private static final String WEEK = "week";

    @Override
    public ResultDo<Map<String, Object>> findCourseListByTime(String classId, String startTime, String endTime) {
        ResultDo<Map<String, Object>> resultDo = new ResultDo<Map<String, Object>>();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List courseList = new ArrayList<>();
        if (classId != null && startTime != null && endTime != null && !"".equals(classId)) {
            courseList = courseMapper.findCourseDetail(classId, startTime, endTime);

            if (courseList != null && courseList.size() != 0) {
                resultDo.setResultDo(InterfaceResult.SUCCESS);
                logger.info(InterfaceResult.SUCCESS.getValue());
            } else {
                resultDo.setResultDo(CourseResult.FIND_FAILURE);
                logger.info(CourseResult.FIND_FAILURE.getValue());
            }
        } else {
            resultDo.setResultDo(CourseResult.FIND_NOT_NULL);
            logger.info(CourseResult.FIND_NOT_NULL.getValue());
        }
        resultMap.put("courseList", courseList);
        resultDo.setResultData(resultMap);
        return resultDo;
    }

    @Override
    public ResultDo<Map<String, Object>> findCourseListByWeek(String classId, Integer currentWeek) {
        ResultDo<Map<String, Object>> resultDo = new ResultDo<Map<String, Object>>();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List courseList = new ArrayList<>();
        if (classId!=null&&!"".equals(classId)&&currentWeek!=null&&currentWeek!=0){
            try {
                String startTime=WeekToDateUtil.getWeekMondayByDate(WeekToDateUtil.plusDay(currentWeek*7,termMapper.getTermStartTime()));
                String endTime=WeekToDateUtil.getWeekFirDayByDate(WeekToDateUtil.plusDay(currentWeek*7,termMapper.getTermStartTime()));
                courseList=courseMapper.findCourseDetail(classId,startTime,endTime);
                if(courseList!=null&&courseList.size()!=0){
                    resultDo.setResultDo(InterfaceResult.SUCCESS);
                    logger.info(InterfaceResult.SUCCESS.getValue());
                }else {
                    resultDo.setResultDo(CourseResult.FIND_FAILURE);
                    logger.info(CourseResult.FIND_FAILURE.getValue());
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }else{
            resultDo.setResultDo(CourseResult.FIND_NOT_NULL);
            logger.info(CourseResult.FIND_NOT_NULL.getValue());
        }
        resultMap.put("courseList", courseList);
        //resultMap.put("courseStateList", dictItemService.findByTypeCode("RECORD_STATE").getResultData());
        resultDo.setResultData(resultMap);
        return resultDo;
    }

    @Override
    public ResultDo<Map<String, Object>> findCourseListByClassId(String classId) {
        ResultDo<Map<String, Object>> resultDo = new ResultDo<Map<String, Object>>();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List courseList = new ArrayList<>();
        Integer totalWeek = termMapper.getTotalWeek();
        /*当前时间*/
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String currentDate = (df.format(new Date()));
        Integer currentWeek = DateToWeekUtil.timeBettwen(termMapper.getTermStartTime().toString(), currentDate, WEEK);
        System.out.println(currentWeek);

        if (classId != null && !"".equals(classId)) {
            /*获取当前日期的周一和周五*/
            courseList = courseMapper.findCourseDetail(classId, MondayAndFridayUtil.getWeekMonday(new Date()), MondayAndFridayUtil.getWeekFriday());
            logger.info(courseList.toString());
        }
        if (courseList != null && courseList.size() != 0) {
            resultDo.setResultDo(InterfaceResult.SUCCESS);
            logger.info(InterfaceResult.SUCCESS.getValue());
            resultMap.put("courseList", courseList);
        } else {
            resultDo.setResultDo(CourseResult.FIND_FAILURE);
            logger.info(CourseResult.FIND_FAILURE.getValue());
        }
        List currentList = new ArrayList<>();
        currentList.add(currentWeek);
        currentList.add(currentDate);
        resultMap.put("currentList", currentList);
        resultMap.put("totalWeek", totalWeek);
        resultDo.setResultData(resultMap);
        return resultDo;
    }

}
