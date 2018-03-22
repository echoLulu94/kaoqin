package com.cxs.extension.act.mapper;

import com.cxs.extension.act.entity.Activity;
import com.cxs.extension.core.utils.CoreMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ActivityMapper  extends CoreMapper<Activity>{

    /**
     * 累计项目次数
     */

    @Select("select count(id) from mak_activity where start_time between #{startTime} and #{endTime}")
    Integer findActivityCount(String startTime,String endTime);


    /**
     * 累计参加项目人数
     */

    @Select("select count(user_id) from mak_activity where start_time between #{startTime} and #{endTime}")
    Integer findPartipantCount(String startTime,String endTime);

    /**
     * 根据考勤状态  准点  迟到  缺勤
     *
     */




    /**
     *显示项目详情  项目名称，考勤员，是否通知，状态，活动（考勤）时间
     */

    @Select("select id,user_id,title,worker_man,introduction,sponsor,sign_up_deadline,activity_state,start_time,end_time" +
            "act_type,platform,meet_area,place,participant_count,participant_remain_count,cust_phone,is_notice,sign_up_fee,activity_url,state,create_time,create_by,update_time,update_by from mak_activity")
    @Results(
            {
                    @Result(column = "title" ,property = "title"),
                    @Result(column = "workerMan",property = "workerMan"),
                    @Result(column = "is_notice",property = "isNotice"),
                    @Result(column = "activity_state",property = "activityState"),
                    @Result(column = "start_time",property = "StartTime")
            }
    )
    List<Activity> findActivitysList();






}
