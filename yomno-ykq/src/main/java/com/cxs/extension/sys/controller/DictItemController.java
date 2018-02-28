package com.cxs.extension.sys.controller;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxs.extension.sys.dto.DictItemDto;
import com.cxs.extension.sys.interceptor.NoAuth;
import com.cxs.extension.sys.result.DictItemResult;
import com.cxs.extension.sys.service.api.DictItemService;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;

/**
 * 
 * @Description: 字典项控制器
 * @ClassName: DictItemController
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日
 */
@Controller
@RequestMapping("/sys")
public class DictItemController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DictItemService dictItemService;

    /*保存字典项*/
    @RequestMapping(value = "/saveDictItem")
	@ResponseBody
	@NoAuth
    public ResultDo<DictItemDto> saveDictItem(DictItemDto dictItemDto){
    	return dictItemService.saveDictItem(dictItemDto);
	}
    
    /*删除字典项*/
    @RequestMapping(value = "/deleteDictItem")
	@ResponseBody
	@NoAuth
    public ResultDo<String> deleteDictItemById(String id){
    	return dictItemService.deleteDictItemById(id);
	}

	/*删除字典项*/
    @RequestMapping(value = "/deleteAllDictItem")
	@ResponseBody
	@NoAuth
    public ResultDo<String []> deleteAllDictItem(String [] ids){
    	ResultDo<String []> resultDo = new ResultDo<String []>();
		try {
			resultDo = dictItemService.deleteDictItemByIds(ids);
		} catch (Exception e) {
			resultDo.setResultDo(DictItemResult.DELETE_BY_IDS_FAILURE);
			logger.error(DictItemResult.DELETE_BY_IDS_FAILURE.getValue(), e);
		}
		return resultDo;
	}
    
    /*更新字典项*/
    @RequestMapping(value = "/updateDictItem")
	@ResponseBody
	@NoAuth
    public ResultDo<DictItemDto> updateDictItem(DictItemDto dictItemDto){
    	return dictItemService.updateDictItem(dictItemDto);
	}

    /*显示字典项详情*/
	@RequestMapping("/viewDictItem")
	@ResponseBody
	@NoAuth
	public ResultDo<DictItemDto> viewDictItem(String id){
		logger.info("dictItemId:"+id);
		return dictItemService.findDictItemById(id);
	}

	/*查询字典项*/
	@RequestMapping("/findDictItem")
	@ResponseBody
	@NoAuth
	public ResultDo<PageDto<DictItemDto>> findDictItem(PageDto<DictItemDto> pageDto, DictItemDto dictItemDto){
		return dictItemService.findDictItem(pageDto, dictItemDto);
	}
	/*分页字典项初始化 */
	@RequestMapping(value = "/initItemMap")
	@ResponseBody
	@NoAuth
	public ResultDo<Map<String, Object>> initItemMap(PageDto<DictItemDto> pageDto, DictItemDto dictItemDto){
			return dictItemService.initItemMap(pageDto, dictItemDto);
	 }
	
	 
}
