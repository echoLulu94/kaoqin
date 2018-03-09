package com.cxs.extension.ath.service.api;

import com.cxs.framework.dto.ResultDo;

import java.util.Map;

public interface CourseService {

    ResultDo<Map<String,Object>> findCourseList( String classId, Long startTime, Long endTime);
}
