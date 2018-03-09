package com.cxs.extension.sys.utils;

import java.util.List;

import com.cxs.extension.sys.dto.DictItemDto;
import com.cxs.extension.sys.entity.DictItem;
/**
* 
* @Description: 字典项DTO和字典项互转工具类
* @ClassName: DictItemParseUtil
* @author: ryan.guo   
* @email: chinazan@qq.com
*/
public class DictItemParseUtil{

	/**
	 * 
	 * entity转dto，不拷贝值为null的属性
	 * @param dictItem 源字典项entity
	 * @param dictItemDto 目标字典项dto
	 */
	public static void parseToDto(DictItem dictItem, DictItemDto dictItemDto){
		parseToDto(dictItem, dictItemDto, false);
	}
	/**
	 * 
	 * entity转dto
	 * @param dictItem 源字典项entity
	 * @param dictItemDto 目标字典项dto
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDto(DictItem dictItem, DictItemDto dictItemDto, Boolean flag){
		if(flag){
			dictItemDto.setId(dictItem.getId());
			dictItemDto.setTypeCode(dictItem.getTypeCode());
			dictItemDto.setTypeName(dictItem.getTypeName());
			dictItemDto.setItemCode(dictItem.getItemCode());
			dictItemDto.setItemValue(dictItem.getItemValue());
			dictItemDto.setItemName(dictItem.getItemName());
			dictItemDto.setState(dictItem.getState());
			dictItemDto.setScort(dictItem.getScort());
			dictItemDto.setItemDes(dictItem.getItemDes());
			dictItemDto.setCreateTime(dictItem.getCreateTime());
			dictItemDto.setUpdateTime(dictItem.getUpdateTime());
		}else{
			if(null!=dictItem.getId()){
				dictItemDto.setId(dictItem.getId());
			}
			if(null!=dictItem.getTypeCode()){
				dictItemDto.setTypeCode(dictItem.getTypeCode());
			}
			if(null!=dictItem.getTypeName()){
				dictItemDto.setTypeName(dictItem.getTypeName());
			}
			if(null!=dictItem.getItemCode()){
				dictItemDto.setItemCode(dictItem.getItemCode());
			}
			if(null!=dictItem.getItemValue()){
				dictItemDto.setItemValue(dictItem.getItemValue());
			}
			if(null!=dictItem.getItemName()){
				dictItemDto.setItemName(dictItem.getItemName());
			}
			if(null!=dictItem.getState()){
				dictItemDto.setState(dictItem.getState());
			}
			if(null!=dictItem.getScort()){
				dictItemDto.setScort(dictItem.getScort());
			}
			if(null!=dictItem.getItemDes()){
				dictItemDto.setItemDes(dictItem.getItemDes());
			}
			if(null!=dictItem.getCreateTime()){
				dictItemDto.setCreateTime(dictItem.getCreateTime());
			}
			if(null!=dictItem.getUpdateTime()){
				dictItemDto.setUpdateTime(dictItem.getUpdateTime());
			}

		}
	}

	/**
	 * dto转entity，不拷贝值为null的属性
	 * @param dictItemDto 源字典项dto
	 * @param dictItem 目标字典项entity
	 */
	public static void parseToEntity(DictItemDto dictItemDto, DictItem dictItem){
		parseToEntity(dictItemDto, dictItem, false);
	}
	
	/**
	 * dto转entity
	 * @param dictItemDto 源字典项dto
	 * @param dictItem 目标字典项entity
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntity(DictItemDto dictItemDto, DictItem dictItem, Boolean flag){
		if(flag){
			dictItem.setId(dictItemDto.getId());
			dictItem.setTypeCode(dictItemDto.getTypeCode());
			dictItem.setTypeName(dictItemDto.getTypeName());
			dictItem.setItemCode(dictItemDto.getItemCode());
			dictItem.setItemValue(dictItemDto.getItemValue());
			dictItem.setItemName(dictItemDto.getItemName());
			dictItem.setState(dictItemDto.getState());
			dictItem.setScort(dictItemDto.getScort());
			dictItem.setItemDes(dictItemDto.getItemDes());
			dictItem.setCreateTime(dictItemDto.getCreateTime());
			dictItem.setUpdateTime(dictItemDto.getUpdateTime());
		}else{
			if(null!=dictItemDto.getId()){
				dictItem.setId(dictItemDto.getId());
			}
			if(null!=dictItemDto.getTypeCode()){
				dictItem.setTypeCode(dictItemDto.getTypeCode());
			}
			if(null!=dictItemDto.getTypeName()){
				dictItem.setTypeName(dictItemDto.getTypeName());
			}
			if(null!=dictItemDto.getItemCode()){
				dictItem.setItemCode(dictItemDto.getItemCode());
			}
			if(null!=dictItemDto.getItemValue()){
				dictItem.setItemValue(dictItemDto.getItemValue());
			}
			if(null!=dictItemDto.getItemName()){
				dictItem.setItemName(dictItemDto.getItemName());
			}
			if(null!=dictItemDto.getState()){
				dictItem.setState(dictItemDto.getState());
			}
			if(null!=dictItemDto.getScort()){
				dictItem.setScort(dictItemDto.getScort());
			}
			if(null!=dictItemDto.getItemDes()){
				dictItem.setItemDes(dictItemDto.getItemDes());
			}
			if(null!=dictItemDto.getCreateTime()){
				dictItem.setCreateTime(dictItemDto.getCreateTime());
			}
			if(null!=dictItemDto.getUpdateTime()){
				dictItem.setUpdateTime(dictItemDto.getUpdateTime());
			}
		}
	}
	
	/**
	 * entity列表转dto列表，不拷贝值为null的属性
	 * @param dictItemList 源字典项entity列表
	 * @param dictItemDtoList 目标字典项dto列表
	 */
	public static void parseToDtoList(List<DictItem> dictItemList, List<DictItemDto> dictItemDtoList ){
		parseToDtoList(dictItemList, dictItemDtoList, false);
	}
	
	/**
	 * entity列表转dto列表，
	 * @param dictItemList 源字典项entity列表
	 * @param dictItemDtoList 目标字典项dto列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToDtoList(List<DictItem> dictItemList, List<DictItemDto> dictItemDtoList, Boolean flag){
		if(null!=dictItemList&&!dictItemList.isEmpty()){
			for (DictItem dictItem:dictItemList) {
				DictItemDto dictItemDto = new DictItemDto();
				parseToDto(dictItem, dictItemDto, flag);
				dictItemDtoList.add(dictItemDto);
			}
		}
	}

	/**
	 * dto列表转entity列表，不拷贝值为null的属性
	 * @param dictItemDtoList 源字典项dto列表
	 * @param dictItemList 目标字典项entity列表
	 */
	public static void parseToEntityList(List<DictItemDto> dictItemDtoList, List<DictItem> dictItemList){
		parseToEntityList(dictItemDtoList, dictItemList, false);
	}


	/**
	 * dto列表转entity列表
	 * @param dictItemDtoList 源字典项dto列表
	 * @param dictItemList 目标字典项entity列表
	 * @param flag 是否拷贝值为null的属性，默认为false不拷贝
	 */
	public static void parseToEntityList(List<DictItemDto> dictItemDtoList, List<DictItem> dictItemList, Boolean flag){
		if(null!=dictItemDtoList&&!dictItemDtoList.isEmpty()){
			for (DictItemDto dictItemDto:dictItemDtoList) {
				DictItem dictItem = new DictItem();
				parseToEntity(dictItemDto,dictItem,flag);
				dictItemList.add(dictItem);
			}
		}
	}
}
