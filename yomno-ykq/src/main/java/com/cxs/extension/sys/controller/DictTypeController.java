package com.cxs.extension.sys.controller;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxs.extension.sys.dto.DictTypeDto;
import com.cxs.extension.sys.interceptor.NoAuth;
import com.cxs.extension.sys.result.DictTypeResult;
import com.cxs.extension.sys.service.api.DictTypeService;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;

/**
 * 
 * @Description: 字典类型控制器
 * @ClassName: DictTypeController
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日
 */
@Controller
@RequestMapping("/sys")
public class DictTypeController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DictTypeService dictTypeService;
    
    /*保存字典类型*/
    @RequestMapping(value = "/saveDictType")
	@ResponseBody
	@NoAuth
    public ResultDo<DictTypeDto> saveDictType(DictTypeDto dictTypeDto){
    	return dictTypeService.saveDictType(dictTypeDto);
	}
    
    /*删除字典类型*/
    @RequestMapping(value = "/deleteDictType")
	@ResponseBody
	@NoAuth
    public ResultDo<String> deleteDictTypeById(String id){
    	return dictTypeService.deleteDictTypeById(id);
	}

	/*删除字典类型*/
    @RequestMapping(value = "/deleteAllDictType")
	@ResponseBody
	@NoAuth
    public ResultDo<String []> deleteAllDictType(String [] ids){
    	ResultDo<String []> resultDo = new ResultDo<String []>();
		try {
			resultDo = dictTypeService.deleteDictTypeByIds(ids);
		} catch (Exception e) {
			resultDo.setResultDo(DictTypeResult.DELETE_BY_IDS_FAILURE);
			logger.error(DictTypeResult.DELETE_BY_IDS_FAILURE.getValue(), e);
		}
		return resultDo;
	}
    
    /*更新字典类型*/
    @RequestMapping(value = "/updateDictType")
	@ResponseBody
	@NoAuth
    public ResultDo<DictTypeDto> updateDictType(DictTypeDto dictTypeDto){
    	return dictTypeService.updateDictType(dictTypeDto);
	}

    /*显示字典类型详情*/
	@RequestMapping("/viewDictType")
	@ResponseBody
	@NoAuth
	public ResultDo<DictTypeDto> viewDictType(String id){
		logger.info("dictTypeId:"+id);
		return dictTypeService.findDictTypeById(id);
	}

	/*根据查询条件分页查询字典类型对象*/
	@RequestMapping("/findDictType")
	@ResponseBody
	@NoAuth
	public ResultDo<PageDto<DictTypeDto>> findDictType(PageDto<DictTypeDto> pageDto, DictTypeDto dictTypeDto){
		return dictTypeService.findDictType(pageDto, dictTypeDto);
	}
	/*分页字典类型初始化*/
	@RequestMapping("/initTypeMap")
	@ResponseBody
	@NoAuth
	public ResultDo<Map<String, Object>> initTypeMap(PageDto<DictTypeDto> pageDto, DictTypeDto dictTypeDto){
		return dictTypeService.initTypeMap(pageDto, dictTypeDto);
 }
}
