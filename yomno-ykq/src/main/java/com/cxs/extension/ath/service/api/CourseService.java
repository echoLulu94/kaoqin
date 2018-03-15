package com.cxs.extension.ath.service.api;

import com.cxs.framework.dto.ResultDo;

import java.util.Map;

public interface CourseService {


    ResultDo<Map<String,Object>> findCourseListByTime(String classId, String  startTime, String endTime);

    ResultDo<Map<String,Object>> findCourseListByWeek(String classId, Integer currentWeek);

    ResultDo<Map<String,Object>> findCourseListByClassId(String classId);



}
