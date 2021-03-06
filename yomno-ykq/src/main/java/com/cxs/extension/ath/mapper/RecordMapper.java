package com.cxs.extension.ath.mapper;

import com.cxs.extension.ath.entity.Course;
import com.cxs.extension.ath.entity.Record;
import com.cxs.extension.core.utils.CoreMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface RecordMapper extends CoreMapper<Record>{


    @Select("select record_state as recordState from ath_record where record_id=#{recordId}")
    @Results({
            @Result(column = "record_state",property = "recordState")
    })
    String   getRecordStateById(String recordId);


}
