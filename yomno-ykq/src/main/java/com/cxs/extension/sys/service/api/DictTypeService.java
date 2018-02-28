package com.cxs.extension.sys.service.api;

import java.util.List;
import java.util.Map;

import com.cxs.extension.sys.dto.DictTypeDto;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;


/**
 * 
 * @Description: 字典类型业务处理接口定义
 * @ClassName: DictTypeService 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日 
 *
 */
public interface DictTypeService {
	
    /**
     * 保存字典类型
     * @param dictTypeDto 需保存字典类型数据对象
     * @return
     */
    ResultDo<DictTypeDto> saveDictType(DictTypeDto dictTypeDto);
    
    /**
     * 根据id删除字典类型
     * @param id id
     * @return
     */
    ResultDo<String> deleteDictTypeById(String id);
	
    /**
     * 根据id数组批量删除字典类型
     * @param ids id数组
     * @return
     */
	ResultDo<String []> deleteDictTypeByIds(String[] ids) throws Exception;

    /**
     * 根据id列表批量删除字典类型
     * @param idList id列表
     * @return
     */
	ResultDo<List<String>> deleteDictTypeByIdList(List<String> idList) throws Exception;
    
	/**
	 * 更新字典类型信息
	 * @param dictTypedto 需更新字典类型数据对象
	 * @return
	 */
    ResultDo<DictTypeDto> updateDictType(DictTypeDto dictTypedto);
    
    /**
     * 根据id查找字典类型
     * @param id id
     * @return
     */
    ResultDo<DictTypeDto> findDictTypeById(String id);
    
    /**
     * 分页查询字典类型信息
     * @param page 分页对象
     * @return
     */
	ResultDo<PageDto<DictTypeDto>> findDictType(PageDto<DictTypeDto> pageDto);
	
	/**
	 * 根据查询条件分页查询字典类型对象
	 * @param page 分页对象
	 * @param dictTypedto 查询条件
	 * @return
	 */
	ResultDo<PageDto<DictTypeDto>> findDictType(PageDto<DictTypeDto> pageDto, DictTypeDto dictTypedto);
	 /**
     * 分页字典类型初始化
     * @return
     */
	ResultDo<Map<String, Object>> initTypeMap(PageDto<DictTypeDto> pageDto, DictTypeDto dictTypeDto);
    /**
     * 字典项下拉框
     * @param dictTypeDto
     * @return
     */
	ResultDo<List<DictTypeDto>> selectAllType();
}