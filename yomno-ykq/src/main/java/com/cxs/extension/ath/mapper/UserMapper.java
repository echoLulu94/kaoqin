package com.cxs.extension.ath.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.cxs.extension.ath.entity.User;
import com.cxs.extension.core.utils.CoreMapper;

/**
 * 
 * @Description: 用户数据库操作封装类
 * @ClassName: UserMapper 
 * @author: huimin.wu
 * @email: huimin.wu@iyomoo.com
 * @date: 2017年5月21日 
 *
 */
@Repository
public interface UserMapper extends CoreMapper<User> {

	/**
	 * 根据手机号查找
	 * @param phone
	 * @return
	 */
	@Select("select * from ath_user where phone = #{phone}")
	User findByPhone(@Param("phone") String phone);


	/**
	 * 根据学号查询
	 * @param id
	 * @return
	 */
	@Select("select * from ath_user where id = #{id}")
	User findOneById(@Param("id") String id);

	/**
	 *更改联系方式
	 * @param phone
	 * @param id
	 */
	@Update("update ath_user set phone = #{phone}  where id = #{id}")
	void updateToPhone(@Param("phone") String phone, @Param("id") String id);


	@Select("select * from ath_user where en_name = #{enName}")
	User findByEnName(@Param("enName")String enName);

	/**
	 * 根据ids删除资源
	 * @param ids
	 */
	@Delete("delete from ath_user where id in (${ids})")
	void deleteByIds(@Param("ids") String ids);
			
	/**
	 *  
	 * @param pwd
	 * @param init_pwd
	 * @param id
	 */
	@Update("update ath_user set pwd = #{pwd}  where id = #{id}")
	void updateToPwd(@Param("pwd") String pwd, @Param("id") String id); 
	
	/**
	 *  
	 * @param pwd
	 * @param init_pwd
	 * @param id
	 */
	@Update("update ath_user set pwd = #{pwd},init_pwd = #{init_pwd}  where id = #{id}")
	void updateBySendMes(@Param("pwd") String pwd,@Param("init_pwd") String init_pwd, @Param("id") String id);

}
