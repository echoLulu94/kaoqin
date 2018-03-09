package com.cxs.extension.sys.service.api;

import java.util.List;
import java.util.Map;

import com.cxs.extension.sys.dto.DictItemDto;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;


/**
 * 
 * @Description: 字典项业务处理接口定义
 * @ClassName: DictItemService 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日 
 *
 */
public interface DictItemService {
    /**
     * 保存字典项
     * @param dictItemDto 需保存字典项数据对象
     * @return
     */
    ResultDo<DictItemDto> saveDictItem(DictItemDto dictItemDto);
    
    /**
     * 根据id删除字典项
     * @param id id
     * @return
     */
    ResultDo<String> deleteDictItemById(String id);
	
    /**
     * 根据id数组批量删除字典项
     * @param ids id数组
     * @return
     */
	ResultDo<String []> deleteDictItemByIds(String[] ids) throws Exception;

    /**
     * 根据id列表批量删除字典项
     * @param idList id列表
     * @return
     */
	ResultDo<List<String>> deleteDictItemByIdList(List<String> idList) throws Exception;
    
	/**
	 * 更新字典项信息
	 * @param dictItemdto 需更新字典项数据对象
	 * @return
	 */
    ResultDo<DictItemDto> updateDictItem(DictItemDto dictItemdto);
    
    /**
     * 根据id查找字典项
     * @param id id
     * @return
     */
    ResultDo<DictItemDto> findDictItemById(String id);
    
    /**
     * 分页查询字典项信息
     * @param page 分页对象
     * @return
     */
	ResultDo<PageDto<DictItemDto>> findDictItem(PageDto<DictItemDto> pageDto);
	
	/**
	 * 根据查询条件分页查询字典项对象
	 * @param page 分页对象
	 * @param dictItemdto 查询条件
	 * @return
	 */
	ResultDo<PageDto<DictItemDto>> findDictItem(PageDto<DictItemDto> pageDto, DictItemDto dictItemdto);

	/**
	 * 字典项管理首页初始化 
	 * @param 
     * @return
	 */
	ResultDo<Map<String, Object>> initItemMap(PageDto<DictItemDto> pageDto, DictItemDto dictItemDto);
	
	/**
	 * 查询字典项根据type和state
	 * @param typeCode 字典项编码
     * @return
	 */
	ResultDo<List<DictItemDto>> findByTypeCode(String typeCode);
	/**
	 * 判断重复
	 * @param 
	 * @return 
     * @return
	 */
	// ResultDo<String> deleteDictItemById(String id);
	//ResultDo<boolean> void decideRepeat();
	
	/**
	 * 刷新字典项缓存
	 */
	void refreshDictCache();
}