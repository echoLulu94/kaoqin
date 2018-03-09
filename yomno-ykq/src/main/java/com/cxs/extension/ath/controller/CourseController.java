package com.cxs.extension.ath.controller;


import com.cxs.extension.ath.dto.UserDto;
import com.cxs.extension.ath.service.api.CourseService;
import com.cxs.extension.sys.interceptor.CorsInterceptor;
import com.cxs.extension.sys.interceptor.NoAuth;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/cou")
public class CourseController {


    private final Logger logger = LoggerFactory.getLogger(CorsInterceptor.class);

    @Autowired
    private CourseService courseService;


    @RequestMapping("findCourseList")
    @ResponseBody
    @NoAuth
    public ResultDo<Map<String, Object>> findCourseList(String classId, Long startTime, Long endTime) {



            return null;


    }





}
