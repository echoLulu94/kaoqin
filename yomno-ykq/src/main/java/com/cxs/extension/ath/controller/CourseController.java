package com.cxs.extension.ath.controller;


import com.cxs.extension.ath.service.api.CourseService;
import com.cxs.extension.sys.interceptor.NoAuth;
import com.cxs.framework.dto.ResultDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("findCourseList")
    @NoAuth
    @ResponseBody
    public ResultDo<Map<String, Object>> findCourseList(String classId, Long startTime, Long endTime) {
       /* classId="0508201";
        startTime=(long)20170801;
        endTime=(long)20170912;*/
       return  courseService.findCourseList(classId,startTime,endTime);
    }


}
