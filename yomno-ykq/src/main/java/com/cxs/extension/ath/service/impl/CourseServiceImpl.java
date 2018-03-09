package com.cxs.extension.ath.service.impl;


import com.cxs.extension.ath.entity.Course;
import com.cxs.extension.ath.mapper.CourseMapper;
import com.cxs.extension.ath.service.api.CourseService;
import com.cxs.framework.dto.ResultDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl  implements CourseService{

    @Autowired
    private CourseMapper courseMapper;
    @Override
    public ResultDo<Course> findCourseDetail(String classId, Long startTime, Long endTime) {
        Course course=new Course();
        ResultDo<Course> resultDo = new ResultDo<Course>();
        /*当前时间*/
        long time = System.currentTimeMillis();

        if(classId!=null&&startTime!=null&&endTime!=null&&!"".equals(classId)){
            course= courseMapper.findCourseDetail(classId,startTime,endTime);







        }








        return resultDo;
    }
}
