package com.cxs.extension.ath.mapper;

import com.cxs.extension.ath.entity.Course;
import com.cxs.extension.core.utils.CoreMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper extends CoreMapper<Course> {

    /**
     * 根据日期 以及班级 查询课程列表
     * @param
     * @return
     */


    @Select("Select  c.class_id as classId, c.course_name as courseName,c.course_order as courseOrder,r.record_state as recordState,c.course_time as courseTime " +
            "from ath_course c inner join  ath_record r on r.id=c.record_id " +
            "where c.class_id= #{classId} and c.course_time between #{startTime} and #{endTime}" )
    List<Course> findCourseDetail(@Param("classId") String classId , @Param("startTime") Long startTime, @Param("endTime")Long endTime);

    /**
     * 根据班级 返回当前周的课程列表
     * @param classId
     * @return 当前周的课程列表
     */

    @Select("Select  c.class_id as classId, c.course_name as courseName,c.course_order as courseOrder,r.record_state as recordState,c.course_time as courseTime " +
            "from ath_course c inner join  ath_record r on r.id=c.record_id " +
            "where c.class_id= #{classId} and c.course_time = #{dateTime}")
    List<Course> findWeekCourseDetail(@Param("classId") String classId , @Param("startTime") Long dateTime);














}
