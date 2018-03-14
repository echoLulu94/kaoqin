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
    public ResultDo<Map<String, Object>> findCourseList(@RequestParam(value = "classId",required = true) String classId,@RequestParam(value = "startTime",required = true) Long startTime, @RequestParam(value = "endTime",required = true) Long endTime) {
       return  courseService.findCourseList(classId,startTime,endTime);
    }


}
