package com.cxs.extension.ath.utils;

import java.util.List;

import com.cxs.extension.ath.dto.UserDto;
import com.cxs.extension.ath.entity.User;
/**
* 
* @Description: 用户DTO和用户互转工具类
* @ClassName: UserParseUtil
* @author: ryan.guo   
* @email: chinazan@qq.com
*/
public class UserParseUtil{

	/**
	 * 
	 * entity转dto，不拷贝值为null的属性
	 * @param user 源用户entity
	 * @param userDto 目标用户dto
	 */
	public static void parseToDto(User user, UserDto userDto){
		parseToDto(user, userDto, false);
	}
	/**
	 * 
	 * entity转dto
	 * @param user 源用户entity
	 * @param userDto 目标用户dto
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDto(User user, UserDto userDto, Boolean flag){
		if(flag){
			userDto.setId(user.getId());
			userDto.setNickName(user.getNickName());
			userDto.setEnName(user.getEnName());
			userDto.setRealName(user.getRealName());
			userDto.setUserType(user.getUserType());
			userDto.setPwd(user.getPwd());
			userDto.setPhone(user.getPhone());
			userDto.setInitPwd(user.getInitPwd());
			userDto.setSex(user.getSex());
			userDto.setBirthday(user.getBirthday());
			userDto.setIdcard(user.getIdcard());
			userDto.setHeadImgUrl(user.getHeadImgUrl());
			userDto.setEmail(user.getEmail());
			userDto.setSalt(user.getSalt());
			userDto.setLocked(user.getLocked());
			userDto.setLoginFailCount(user.getLoginFailCount());
			userDto.setRegisterTime(user.getRegisterTime());
			userDto.setLoginTime(user.getLoginTime());
			userDto.setLoginChannel(user.getLoginChannel());
			userDto.setLoginDeviceId(user.getLoginDeviceId());
			userDto.setLoginIp(user.getLoginIp());
			userDto.setCreateBy(user.getCreateBy());
			userDto.setCreateTime(user.getCreateTime());
			userDto.setUpdateBy(user.getUpdateBy());
			userDto.setUpdateTime(user.getUpdateTime());
			userDto.setCode(user.getCode());
		}else{
			if(null!=user.getId()){
				userDto.setId(user.getId());
			}
			if(null!=user.getNickName()){
				userDto.setNickName(user.getNickName());
			}
			if(null!=user.getEnName()){
				userDto.setEnName(user.getEnName());
			}
			if(null!=user.getRealName()){
				userDto.setRealName(user.getRealName());
			}
			if(null!=user.getUserType()){
				userDto.setUserType(user.getUserType());
			}
			if(null!=user.getPwd()){
				userDto.setPwd(user.getPwd());
			}
			if(null!=user.getPhone()){
				userDto.setPhone(user.getPhone());
			}
			if(null!=user.getInitPwd()){
				userDto.setInitPwd(user.getInitPwd());
			}
			if(null!=user.getSex()){
				userDto.setSex(user.getSex());
			}
			if(null!=user.getBirthday()){
				userDto.setBirthday(user.getBirthday());
			}
			if(null!=user.getIdcard()){
				userDto.setIdcard(user.getIdcard());
			}
			if(null!=user.getHeadImgUrl()){
				userDto.setHeadImgUrl(user.getHeadImgUrl());
			}
			if(null!=user.getEmail()){
				userDto.setEmail(user.getEmail());
			}
			if(null!=user.getSalt()){
				userDto.setSalt(user.getSalt());
			}
			if(null!=user.getLocked()){
				userDto.setLocked(user.getLocked());
			}
			if(null!=user.getLoginFailCount()){
				userDto.setLoginFailCount(user.getLoginFailCount());
			}
			if(null!=user.getRegisterTime()){
				userDto.setRegisterTime(user.getRegisterTime());
			}
			if(null!=user.getLoginTime()){
				userDto.setLoginTime(user.getLoginTime());
			}
			if(null!=user.getLoginChannel()){
				userDto.setLoginChannel(user.getLoginChannel());
			}
			if(null!=user.getLoginDeviceId()){
				userDto.setLoginDeviceId(user.getLoginDeviceId());
			}
			if(null!=user.getLoginIp()){
				userDto.setLoginIp(user.getLoginIp());
			}
			if(null!=user.getCreateBy()){
				userDto.setCreateBy(user.getCreateBy());
			}
			if(null!=user.getCreateTime()){
				userDto.setCreateTime(user.getCreateTime());
			}
			if(null!=user.getUpdateBy()){
				userDto.setUpdateBy(user.getUpdateBy());
			}
			if(null!=user.getUpdateTime()){
				userDto.setUpdateTime(user.getUpdateTime());
			}
			if(null!=user.getCode()){
				userDto.setCode(user.getCode());
			}

		}
	}

	/**
	 * dto转entity，不拷贝值为null的属性
	 * @param userDto 源用户dto
	 * @param user 目标用户entity
	 */
	public static void parseToEntity(UserDto userDto, User user){
		parseToEntity(userDto, user, false);
	}
	
	/**
	 * dto转entity
	 * @param userDto 源用户dto
	 * @param user 目标用户entity
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntity(UserDto userDto, User user, Boolean flag){
		if(flag){
			user.setId(userDto.getId());
			user.setNickName(userDto.getNickName());
			user.setEnName(userDto.getEnName());
			user.setRealName(userDto.getRealName());
			user.setUserType(userDto.getUserType());
			user.setPwd(userDto.getPwd());
			user.setPhone(userDto.getPhone());
			user.setInitPwd(userDto.getInitPwd());
			user.setSex(userDto.getSex());
			user.setBirthday(userDto.getBirthday());
			user.setIdcard(userDto.getIdcard());
			user.setHeadImgUrl(userDto.getHeadImgUrl());
			user.setEmail(userDto.getEmail());
			user.setSalt(userDto.getSalt());
			user.setLocked(userDto.getLocked());
			user.setLoginFailCount(userDto.getLoginFailCount());
			user.setRegisterTime(userDto.getRegisterTime());
			user.setLoginTime(userDto.getLoginTime());
			user.setLoginChannel(userDto.getLoginChannel());
			user.setLoginDeviceId(userDto.getLoginDeviceId());
			user.setLoginIp(userDto.getLoginIp());
			user.setCreateBy(userDto.getCreateBy());
			user.setCreateTime(userDto.getCreateTime());
			user.setUpdateBy(userDto.getUpdateBy());
			user.setUpdateTime(userDto.getUpdateTime());
			user.setCode(userDto.getCode());
		}else{
			if(null!=userDto.getId()){
				user.setId(userDto.getId());
			}
			if(null!=userDto.getNickName()){
				user.setNickName(userDto.getNickName());
			}
			if(null!=userDto.getEnName()){
				user.setEnName(userDto.getEnName());
			}
			if(null!=userDto.getRealName()){
				user.setRealName(userDto.getRealName());
			}
			if(null!=userDto.getUserType()){
				user.setUserType(userDto.getUserType());
			}
			if(null!=userDto.getPwd()){
				user.setPwd(userDto.getPwd());
			}
			if(null!=userDto.getPhone()){
				user.setPhone(userDto.getPhone());
			}
			if(null!=userDto.getInitPwd()){
				user.setInitPwd(userDto.getInitPwd());
			}
			if(null!=userDto.getSex()){
				user.setSex(userDto.getSex());
			}
			if(null!=userDto.getBirthday()){
				user.setBirthday(userDto.getBirthday());
			}
			if(null!=userDto.getIdcard()){
				user.setIdcard(userDto.getIdcard());
			}
			if(null!=userDto.getHeadImgUrl()){
				user.setHeadImgUrl(userDto.getHeadImgUrl());
			}
			if(null!=userDto.getEmail()){
				user.setEmail(userDto.getEmail());
			}
			if(null!=userDto.getSalt()){
				user.setSalt(userDto.getSalt());
			}
			if(null!=userDto.getLocked()){
				user.setLocked(userDto.getLocked());
			}
			if(null!=userDto.getLoginFailCount()){
				user.setLoginFailCount(userDto.getLoginFailCount());
			}
			if(null!=userDto.getRegisterTime()){
				user.setRegisterTime(userDto.getRegisterTime());
			}
			if(null!=userDto.getLoginTime()){
				user.setLoginTime(userDto.getLoginTime());
			}
			if(null!=userDto.getLoginChannel()){
				user.setLoginChannel(userDto.getLoginChannel());
			}
			if(null!=userDto.getLoginDeviceId()){
				user.setLoginDeviceId(userDto.getLoginDeviceId());
			}
			if(null!=userDto.getLoginIp()){
				user.setLoginIp(userDto.getLoginIp());
			}
			if(null!=userDto.getCreateBy()){
				user.setCreateBy(userDto.getCreateBy());
			}
			if(null!=userDto.getCreateTime()){
				user.setCreateTime(userDto.getCreateTime());
			}
			if(null!=userDto.getUpdateBy()){
				user.setUpdateBy(userDto.getUpdateBy());
			}
			if(null!=userDto.getUpdateTime()){
				user.setUpdateTime(userDto.getUpdateTime());
			}
			if(null!=userDto.getCode()){
				user.setCode(userDto.getCode());
			}
		}
	}
	
	/**
	 * entity列表转dto列表，不拷贝值为null的属性
	 * @param userList 源用户entity列表
	 * @param userDtoList 目标用户dto列表
	 */
	public static void parseToDtoList(List<User> userList, List<UserDto> userDtoList ){
		parseToDtoList(userList, userDtoList, false);
	}
	
	/**
	 * entity列表转dto列表，
	 * @param userList 源用户entity列表
	 * @param userDtoList 目标用户dto列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDtoList(List<User> userList, List<UserDto> userDtoList, Boolean flag){
		if(null!=userList&&!userList.isEmpty()){
			for (User user:userList) {
				UserDto userDto = new UserDto();
				parseToDto(user, userDto, flag);
				userDtoList.add(userDto);
			}
		}
	}

	/**
	 * dto列表转entity列表，不拷贝值为null的属性
	 * @param userDtoList 源用户dto列表
	 * @param userList 目标用户entity列表
	 */
	public static void parseToEntityList(List<UserDto> userDtoList, List<User> userList){
		parseToEntityList(userDtoList, userList, false);
	}


	/**
	 * dto列表转entity列表
	 * @param userDtoList 源用户dto列表
	 * @param userList 目标用户entity列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntityList(List<UserDto> userDtoList, List<User> userList, Boolean flag){
		if(null!=userDtoList&&!userDtoList.isEmpty()){
			for (UserDto userDto:userDtoList) {
				User user = new User();
				parseToEntity(userDto,user,flag);
				userList.add(user);
			}
		}
	}
}
