package com.cxs.extension.ath.service.api;

import java.util.List;
import java.util.Map;

import com.cxs.extension.ath.dto.UserDto;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;

/**
 * 
 * @Description: 用户业务处理接口定义
 * @ClassName: UserService 
 * @author: huimin.wu
 * @email: huimin.wu@iyomoo.com
 * @date: 2018年1月21日
 *
 */
public interface UserService {
	
	/**
	 * 根据手机号查用户信息
	 * @param phone 手机号
	 * @return
	 */
	UserDto findByPhone(String phone);


	/**
	 * 根据学号查用户信息
	 * @param id 学号
	 * @return
	 */
	UserDto findOneById(String id);


	/**
	 * 修改联系方式
	 * @param userDto
	 * @param formerPhone
	 * @return
	 */
	ResultDo<UserDto>  resetPhone(UserDto userDto );
    /**
     * 保存用户
     * @param userDto 需保存用户数据对象
     * @return
     * @throws Exception 
     */
    ResultDo<UserDto> saveUser(UserDto userDto);
    
    /**
     * 根据id删除用户
     * @param id id
     * @return
     */
    ResultDo<String> deleteUserById(String id);
	
    /**
     * 根据id数组批量删除用户
     * @param ids id数组
     * @return
     */
	ResultDo<String []> deleteUserByIds(String[] ids);

    /**
     * 根据id列表批量删除用户
     * @param idList id列表
     * @return
     */
	ResultDo<List<String>> deleteUserByIdList(List<String> idList);
    
	/**
	 * 更新用户信息
	 * @param userdto 需更新用户数据对象
	 * @return
	 */
    ResultDo<UserDto> updateUser(UserDto userdto);
    
    /**
     * 根据id查找用户
     * @param id id
     * @return
     */
    ResultDo<UserDto> findUserById(String id);


    /**
     * 分页查询用户信息
     * @return
     */
	ResultDo<PageDto<UserDto>> findUser(PageDto<UserDto> pageDto);
	
	/**
	 * 根据查询条件分页查询用户对象
	 * @param userdto 查询条件
	 * @return
	 */
	ResultDo<Map<String, Object>> findUser(PageDto<UserDto> pageDto, UserDto userdto);
	
    /**
     * 重置密码,设为字典固定值
     * @param userDto
     * @return
     */
	ResultDo<UserDto> resetPwd(UserDto userDto);

    /**
     * 修改密码
     * @param userDto
     * @param formerPwd
     * @return
     */
	ResultDo<UserDto> pwdEdit(UserDto userDto, String formerPwd);
}