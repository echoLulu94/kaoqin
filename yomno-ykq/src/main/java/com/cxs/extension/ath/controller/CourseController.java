package com.cxs.extension.ath.controller;


import com.cxs.extension.ath.service.api.CourseService;
import com.cxs.extension.sys.interceptor.NoAuth;
import com.cxs.framework.dto.ResultDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResultDo<Map<String, Object>> findCourseListByTime(@RequestParam(value = "classId", required = true) String classId, @RequestParam(value = "startTime", required = true) String startTime, @RequestParam(value = "endTime", required = true) String endTime) {
        return courseService.findCourseListByTime(classId, startTime, endTime);
    }

    @RequestMapping("/findWeekCourse")
    @NoAuth
    @ResponseBody
    public ResultDo<Map<String, Object>> findCourseListByClassId(@RequestParam(value = "classId", required = true) String classId) {
        return courseService.findCourseListByClassId(classId);
    }

    @RequestMapping("/findWeekCourse")
    @NoAuth
    @ResponseBody
    public ResultDo<Map<String, Object>> findCourseListByWeek(@RequestParam(value = "classId", required = true) String classId, @RequestParam(value = "currentWeek", required = true) Integer currentWeek) {
        return courseService.findCourseListByWeek(classId, currentWeek);


    }

}
