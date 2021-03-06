package com.cxs.extension.ath.mapper;

import com.cxs.extension.ath.entity.Course;
import com.cxs.extension.core.utils.CoreMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import javax.persistence.ManyToMany;
import java.util.List;

@Repository
public interface CourseMapper extends CoreMapper<Course> {

    /**
     * 根据日期 以及班级 查询课程列表
     * @param
     * @return
     */

    @Select("Select  class_id as classId,course_name as courseName,course_order as courseOrder,course_location as courseLocation,record_state as recordState,course_time as courseTime " +
            "from ath_course  " +
            "where class_id= #{classId} and course_time between #{startTime} and #{endTime}" )
 /* @Results({
            @Result(column = "course_name",property = "courseName",javaType = String.class),
            @Result(column = "course_order",property = "courseOrder",javaType = String.class),
            @Result(column = "course_location",property = "courseLocation",javaType = String.class),
            @Result(column = "record_state",property = "recordState",javaType = String.class)
    })*/
    List<Course> findCourseDetail(@Param("classId") String classId , @Param("startTime") String  startTime, @Param("endTime")String endTime);




}
