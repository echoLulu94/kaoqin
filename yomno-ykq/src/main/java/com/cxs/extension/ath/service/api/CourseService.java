package com.cxs.extension.ath.service.api;

import com.cxs.extension.ath.entity.Course;
import com.cxs.framework.dto.ResultDo;

public interface CourseService {

    ResultDo<Course> findCourseDetail(String classId,Long startTime,Long endTime);
}
