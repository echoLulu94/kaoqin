package com.cxs.extension.ath.mapper;

import com.cxs.extension.ath.entity.Term;
import com.cxs.extension.core.utils.CoreMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
public interface TermMapper extends CoreMapper<Term> {

    @Select("select week from ath_term")
     Integer getTotalWeek ();
}
