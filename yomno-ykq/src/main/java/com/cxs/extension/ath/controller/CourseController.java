package com.cxs.extension.ath.controller;


import com.cxs.extension.ath.service.api.CourseService;
import com.cxs.extension.sys.interceptor.NoAuth;
import com.cxs.framework.dto.ResultDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;



    @RequestMapping("findCourseList")
    @NoAuth
    @ResponseBody
    public ResultDo<Map<String, Object>> findCourseListByTime(@RequestParam(value = "classId", required = true) String classId, @RequestParam(value = "startTime", required = true) String startTime, @RequestParam(value = "endTime", required = true) String endTime) {
        return courseService.findCourseListByTime(classId, startTime, endTime);
    }

    @RequestMapping("/findWeekCourseByClassId")
    @NoAuth
    @ResponseBody
    public ResultDo<Map<String, Object>> findCourseListByClassId(@RequestParam(value = "classId", required = true) String classId) {
        return courseService.findCourseListByClassId(classId);
    }

    @RequestMapping("/findWeekCourseByWeek")
    @NoAuth
    @ResponseBody
    public ResultDo<Map<String, Object>> findCourseListByWeek(@RequestParam(value = "classId", required = true) String classId, @RequestParam(value = "week", required = true) Integer week) {
        return courseService.findCourseListByWeek(classId, week);


    }

}
