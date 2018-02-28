package com.cxs.extension.sys.utils;

import java.util.List;

import com.cxs.extension.sys.dto.DictTypeDto;
import com.cxs.extension.sys.entity.DictType;
/**
* 
* @Description: 字典类型DTO和字典类型互转工具类
* @ClassName: DictTypeParseUtil
* @author: ryan.guo   
* @email: chinazan@qq.com
*/
public class DictTypeParseUtil{

	/**
	 * 
	 * entity转dto，不拷贝值为null的属性
	 * @param dictType 源字典类型entity
	 * @param dictTypeDto 目标字典类型dto
	 */
	public static void parseToDto(DictType dictType, DictTypeDto dictTypeDto){
		parseToDto(dictType, dictTypeDto, false);
	}
	/**
	 * 
	 * entity转dto
	 * @param dictType 源字典类型entity
	 * @param dictTypeDto 目标字典类型dto
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDto(DictType dictType, DictTypeDto dictTypeDto, Boolean flag){
		if(flag){
			dictTypeDto.setId(dictType.getId());
			dictTypeDto.setTypeCode(dictType.getTypeCode());
			dictTypeDto.setTypeName(dictType.getTypeName());
			dictTypeDto.setState(dictType.getState());
			dictTypeDto.setTypeDes(dictType.getTypeDes());
			dictTypeDto.setCreateTime(dictType.getCreateTime());
			dictTypeDto.setUpdateTime(dictType.getUpdateTime());
		}else{
			if(null!=dictType.getId()){
				dictTypeDto.setId(dictType.getId());
			}
			if(null!=dictType.getTypeCode()){
				dictTypeDto.setTypeCode(dictType.getTypeCode());
			}
			if(null!=dictType.getTypeName()){
				dictTypeDto.setTypeName(dictType.getTypeName());
			}
			if(null!=dictType.getState()){
				dictTypeDto.setState(dictType.getState());
			}
			if(null!=dictType.getTypeDes()){
				dictTypeDto.setTypeDes(dictType.getTypeDes());
			}
			if(null!=dictType.getCreateTime()){
				dictTypeDto.setCreateTime(dictType.getCreateTime());
			}
			if(null!=dictType.getUpdateTime()){
				dictTypeDto.setUpdateTime(dictType.getUpdateTime());
			}

		}
	}

	/**
	 * dto转entity，不拷贝值为null的属性
	 * @param dictTypeDto 源字典类型dto
	 * @param dictType 目标字典类型entity
	 */
	public static void parseToEntity(DictTypeDto dictTypeDto, DictType dictType){
		parseToEntity(dictTypeDto, dictType, false);
	}
	
	/**
	 * dto转entity
	 * @param dictTypeDto 源字典类型dto
	 * @param dictType 目标字典类型entity
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntity(DictTypeDto dictTypeDto, DictType dictType, Boolean flag){
		if(flag){
			dictType.setId(dictTypeDto.getId());
			dictType.setTypeCode(dictTypeDto.getTypeCode());
			dictType.setTypeName(dictTypeDto.getTypeName());
			dictType.setState(dictTypeDto.getState());
			dictType.setTypeDes(dictTypeDto.getTypeDes());
			dictType.setCreateTime(dictTypeDto.getCreateTime());
			dictType.setUpdateTime(dictTypeDto.getUpdateTime());
		}else{
			if(null!=dictTypeDto.getId()){
				dictType.setId(dictTypeDto.getId());
			}
			if(null!=dictTypeDto.getTypeCode()){
				dictType.setTypeCode(dictTypeDto.getTypeCode());
			}
			if(null!=dictTypeDto.getTypeName()){
				dictType.setTypeName(dictTypeDto.getTypeName());
			}
			if(null!=dictTypeDto.getState()){
				dictType.setState(dictTypeDto.getState());
			}
			if(null!=dictTypeDto.getTypeDes()){
				dictType.setTypeDes(dictTypeDto.getTypeDes());
			}
			if(null!=dictTypeDto.getCreateTime()){
				dictType.setCreateTime(dictTypeDto.getCreateTime());
			}
			if(null!=dictTypeDto.getUpdateTime()){
				dictType.setUpdateTime(dictTypeDto.getUpdateTime());
			}
		}
	}
	
	/**
	 * entity列表转dto列表，不拷贝值为null的属性
	 * @param dictTypeList 源字典类型entity列表
	 * @param dictTypeDtoList 目标字典类型dto列表
	 */
	public static void parseToDtoList(List<DictType> dictTypeList, List<DictTypeDto> dictTypeDtoList ){
		parseToDtoList(dictTypeList, dictTypeDtoList, false);
	}
	
	/**
	 * entity列表转dto列表，
	 * @param dictTypeList 源字典类型entity列表
	 * @param dictTypeDtoList 目标字典类型dto列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDtoList(List<DictType> dictTypeList, List<DictTypeDto> dictTypeDtoList, Boolean flag){
		if(null!=dictTypeList&&!dictTypeList.isEmpty()){
			for (DictType dictType:dictTypeList) {
				DictTypeDto dictTypeDto = new DictTypeDto();
				parseToDto(dictType, dictTypeDto, flag);
				dictTypeDtoList.add(dictTypeDto);
			}
		}
	}

	/**
	 * dto列表转entity列表，不拷贝值为null的属性
	 * @param dictTypeDtoList 源字典类型dto列表
	 * @param dictTypeList 目标字典类型entity列表
	 */
	public static void parseToEntityList(List<DictTypeDto> dictTypeDtoList, List<DictType> dictTypeList){
		parseToEntityList(dictTypeDtoList, dictTypeList, false);
	}


	/**
	 * dto列表转entity列表
	 * @param dictTypeDtoList 源字典类型dto列表
	 * @param dictTypeList 目标字典类型entity列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntityList(List<DictTypeDto> dictTypeDtoList, List<DictType> dictTypeList, Boolean flag){
		if(null!=dictTypeDtoList&&!dictTypeDtoList.isEmpty()){
			for (DictTypeDto dictTypeDto:dictTypeDtoList) {
				DictType dictType = new DictType();
				parseToEntity(dictTypeDto,dictType,flag);
				dictTypeList.add(dictType);
			}
		}
	}
}
