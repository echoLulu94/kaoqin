package com.cxs.extension.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cxs.framework.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//import com.cxs.extension.core.utils.RedisUtil;
import com.cxs.extension.sys.dto.DictItemDto;
import com.cxs.extension.sys.dto.DictTypeDto;
import com.cxs.extension.sys.entity.DictItem;
import com.cxs.extension.sys.mapper.DictItemMapper;
import com.cxs.extension.sys.result.DictItemResult;
import com.cxs.extension.sys.service.api.DictItemService;
import com.cxs.extension.sys.service.api.DictTypeService;
import com.cxs.extension.sys.utils.DictItemParseUtil;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;
import com.cxs.framework.result.InterfaceResult;
import com.cxs.framework.utils.IdUtil;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

/**
 * 
 * @Description: 字典项业务处理实现类
 * @ClassName: DictItemServiceImpl
 * @author: ryan.guo
 * @email: chinazan@qq.com
 * @date: 2017年05月25日
 *
 */
@Service
public class DictItemServiceImpl implements DictItemService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DictItemMapper dictItemMapper;
	@Autowired
	private DictTypeService dictTypeService;
	/**
	 * 保存 新增保存判重
	 */
	@Override
	public ResultDo<DictItemDto> saveDictItem(DictItemDto dictItemDto) {
		ResultDo<DictItemDto> resultDo = new ResultDo<DictItemDto>();
		DictItem dictItem = new DictItem();
		/*系统当前时间*/
		long time = System.currentTimeMillis();
		try {
			if (null != dictItemDto) {
				if (null != dictItemDto.getTypeCode()) {
					if (null != dictItemDto.getItemCode()) {
						if (null != dictItemDto.getScort()) {
							DictItem dictItemTmp = dictItemMapper.selectByTypeCodeAndCodeOrScort(dictItemDto.getTypeCode(),
									dictItemDto.getItemCode(), dictItemDto.getScort());
							if (null != dictItemTmp) {
								if(dictItemDto.getItemCode().equals(dictItemTmp.getItemCode())){
									resultDo.setResultDo(DictItemResult.SAVE_CODE_EXISTS);
									logger.error(DictItemResult.SAVE_CODE_EXISTS.getValue());
								}
								if(dictItemDto.getScort().equals(dictItemTmp.getScort())){
									resultDo.setResultDo(DictItemResult.SAVE_SCORT_EXISTS);
									logger.error(DictItemResult.SAVE_SCORT_EXISTS.getValue());
								}
							} else {
								dictItemDto.setId(IdUtil.getUuid());
								dictItemDto.setCreateTime(time);
								dictItemDto.setUpdateTime(time);
								DictItemParseUtil.parseToEntity(dictItemDto, dictItem);
								dictItemMapper.insert(dictItem);
								resultDo.setResultDo(InterfaceResult.SUCCESS);
								logger.info(InterfaceResult.SUCCESS.getValue());
							}
						} else {
							resultDo.setResultDo(DictItemResult.SAVE_SCORT_NOT_NULL);
							logger.error(DictItemResult.SAVE_SCORT_NOT_NULL.getValue());
						}
					} else {
						resultDo.setResultDo(DictItemResult.SAVE_ITEMCODE_NOT_NULL);
						logger.error(DictItemResult.SAVE_ITEMCODE_NOT_NULL.getValue());
					}
				} else {
					resultDo.setResultDo(DictItemResult.SAVE_TYPECODE_NOT_NULL);
					logger.error(DictItemResult.SAVE_TYPECODE_NOT_NULL.getValue());
				}
			} else {
				resultDo.setResultDo(DictItemResult.SAVE_FAILURE);
				logger.error(DictItemResult.SAVE_FAILURE.getValue());
			}
		} catch (Exception e) {
			resultDo.setResultDo(DictItemResult.SAVE_FAILURE);
			logger.error(DictItemResult.SAVE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(dictItemDto);
//		刷新字典缓存
		refreshDictCache();
		return resultDo;
	}

	@Override
	public ResultDo<String> deleteDictItemById(String id) {
		ResultDo<String> resultDo = new ResultDo<String>();
		try {
			if (null != id && !"".equals(id)) {
				int i = dictItemMapper.deleteByPrimaryKey(id);
				if (i == 0) {
					resultDo.setResultDo(DictItemResult.DELETE_DICTITEM_NOT_EXIST);
					logger.info(DictItemResult.DELETE_DICTITEM_NOT_EXIST.getValue());
				} else {
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.error(InterfaceResult.SUCCESS.getValue());
				}
			} else {
				resultDo.setResultDo(DictItemResult.DELETE_ID_NOT_NULL);
				logger.error(DictItemResult.DELETE_ID_NOT_NULL.getValue());
			}
		} catch (Exception e) {
			resultDo.setResultDo(DictItemResult.DELETE_FAILURE);
			logger.error(DictItemResult.DELETE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(id);
//		刷新字典缓存
		refreshDictCache();
		return resultDo;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<String[]> deleteDictItemByIds(String[] ids) throws Exception {
		ResultDo<String[]> resultDo = new ResultDo<String[]>();
		try {
			if (null != ids && ids.length > 0) {
				for (String shortIds : IdUtil.getIdsList(ids)) {
					dictItemMapper.deleteByIds(shortIds);
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
				}
			} else {
				resultDo.setResultDo(DictItemResult.DELETE_IDS_NOT_NULL);
				logger.error(DictItemResult.DELETE_IDS_NOT_NULL.getValue());
			}
		} catch (Exception e) {
			resultDo.setResultDo(DictItemResult.DELETE_BY_IDS_FAILURE);
			logger.error(DictItemResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(ids);
//		刷新字典缓存
		refreshDictCache();
		return resultDo;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<List<String>> deleteDictItemByIdList(List<String> idList) throws Exception {
		ResultDo<List<String>> resultDo = new ResultDo<List<String>>();
		try {
			if (null != idList && !idList.isEmpty()) {
				for (String shortIds : IdUtil.getIdsList(idList)) {
					dictItemMapper.deleteByIds(shortIds);
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
				}
			} else {
				resultDo.setResultDo(DictItemResult.DELETE_IDS_NOT_NULL);
				logger.error(DictItemResult.DELETE_IDS_NOT_NULL.getValue());
			}
		} catch (Exception e) {
			logger.error(DictItemResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(idList);
//		刷新字典缓存
		refreshDictCache();
		return resultDo;
	}

	/**
	 * 修改 修改保存判重
	 */
	@Override
	public ResultDo<DictItemDto> updateDictItem(DictItemDto dictItemDto) {
		ResultDo<DictItemDto> resultDo = new ResultDo<DictItemDto>();
		DictItem dictItem = new DictItem();
		/*系统当前时间*/
		long time = System.currentTimeMillis();
		try {
			if (null != dictItemDto) {
				if (null != dictItemDto.getId()) {
					if (null != dictItemDto.getTypeCode()) {
						if (null != dictItemDto.getItemCode()) {
							if (null != dictItemDto.getScort()) {
								DictItem dictItemTmp = dictItemMapper.selectByIdAndTypeCodeAndCodeOrScort(dictItemDto.getId(),
										dictItemDto.getTypeCode(), dictItemDto.getItemCode(), dictItemDto.getScort());
								if (null != dictItemTmp) {
									if(dictItemDto.getItemCode().equals(dictItemTmp.getItemCode())){
										resultDo.setResultDo(DictItemResult.DELETE_IDS_NOT_NULL);
										logger.error(DictItemResult.UPDATE_CODE_EXISTS.getValue());
									}
									if(dictItemDto.getScort().equals(dictItemTmp.getScort())){
										resultDo.setResultDo(DictItemResult.UPDATE_SCORT_EXISTS);
										logger.error(DictItemResult.UPDATE_SCORT_EXISTS.getValue());
									}
								} else {
									dictItemDto.setUpdateTime(time);
									DictItemParseUtil.parseToEntity(dictItemDto, dictItem);
									dictItemMapper.updateByPrimaryKeySelective(dictItem);
									resultDo.setResultDo(InterfaceResult.SUCCESS);
									logger.info(InterfaceResult.SUCCESS.getValue());
								}
							} else {
								resultDo.setResultDo(DictItemResult.UPDATE_SCORT_NOT_NULL);
								logger.error(DictItemResult.UPDATE_SCORT_NOT_NULL.getValue());
							}
						} else {
							resultDo.setResultDo(DictItemResult.UPDATE_ITEMCODE_NOT_NULL);
							logger.error(DictItemResult.UPDATE_ITEMCODE_NOT_NULL.getValue());
						}
					} else {
						resultDo.setResultDo(DictItemResult.UPDATE_TYPECODE_NOT_NULL);
						logger.error(DictItemResult.UPDATE_TYPECODE_NOT_NULL.getValue());
					}
				} else {
					resultDo.setResultDo(DictItemResult.UPDATE_ID_NOT_NULL);
					logger.error(DictItemResult.UPDATE_ID_NOT_NULL.getValue());
				}
			} else {
				resultDo.setResultDo(DictItemResult.UPDATE_FAILURE);
				logger.error(DictItemResult.UPDATE_FAILURE.getValue());
			}
		} catch (Exception e) {
			resultDo.setResultDo(DictItemResult.UPDATE_FAILURE);
			logger.error(DictItemResult.UPDATE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(dictItemDto);
//		刷新字典缓存
		refreshDictCache();
		return resultDo;
	}

	@Override
	public ResultDo<DictItemDto> findDictItemById(String id) {
		DictItemDto dictItemDto=new DictItemDto();
		ResultDo<DictItemDto> resultDo =new ResultDo<>();
		try {
			if(id!=null&&"".equals(id)){
                DictItem dictItem=dictItemMapper.selectByPrimaryKey(id);
                DictItemParseUtil.parseToDto(dictItem,dictItemDto);
                resultDo.setResultDo(InterfaceResult.SUCCESS);
                logger.info(InterfaceResult.SUCCESS.getValue());
            }else{
                resultDo.setResultDo(DictItemResult.FIND_BY_ID_NOT_NULL);
                logger.info(DictItemResult.FIND_BY_ID_NOT_NULL.getValue());
            }
		} catch (Exception e) {
			resultDo.setResultDo(DictItemResult.FIND_FAILURE);
			logger.info(DictItemResult.FIND_FAILURE.getValue());
		}
		return  resultDo;
	}

	@Override
	public ResultDo<PageDto<DictItemDto>> findDictItem(PageDto<DictItemDto> pageDto) {
		logger.debug("debug test");
		List<DictItemDto> dictItemDtoList = new ArrayList<DictItemDto>();
		List<DictItem> dictItemList = null;
		ResultDo<PageDto<DictItemDto>> resultDo = new ResultDo<PageDto<DictItemDto>>();
		try {
			pageDto.setTotalRecord(dictItemMapper.selectCount(null));
			PageHelper.startPage(pageDto.getPageCurrent(), pageDto.getPageSize());
			dictItemList = dictItemMapper.selectAll();
			DictItemParseUtil.parseToDtoList(dictItemList, dictItemDtoList);
			pageDto.setPageData(dictItemDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		} catch (Exception e) {
			resultDo.setResultDo(DictItemResult.FIND_FAILURE);
			logger.error(DictItemResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}

	/**
	 * 根据查询条件分页查询字典项对象
	 * 
	 * @param pageDto
	 *            分页对象
	 * @param dictItemDto
	 *            查询条件
	 * @return
	 */
	@Override
	public ResultDo<PageDto<DictItemDto>> findDictItem(PageDto<DictItemDto> pageDto, DictItemDto dictItemDto) {
		List<DictItemDto> dictItemDtoList = new ArrayList<DictItemDto>();
		ResultDo<PageDto<DictItemDto>> resultDo = new ResultDo<PageDto<DictItemDto>>();
		List<DictItem> dictItemList = null;
		try {
			Example example = new Example(DictItem.class);
			example.createCriteria();
			if (StringUtil.isNotEmpty(dictItemDto.getTypeCode())) {
				example.getOredCriteria().get(0).andLike("typeCode", "%" + dictItemDto.getTypeCode() + "%");
			}
			if (StringUtil.isNotEmpty(dictItemDto.getTypeName())) {
				example.getOredCriteria().get(0).andLike("typeName", "%" + dictItemDto.getTypeName() + "%");
			}
			pageDto.setTotalRecord(dictItemMapper.selectCountByExample(example));
			DictItem dictItem = new DictItem();
			PageHelper.startPage(pageDto.getPageCurrent(), pageDto.getPageSize());
			DictItemParseUtil.parseToEntity(dictItemDto, dictItem);
			dictItemList = dictItemMapper.selectByExample(example);
			DictItemParseUtil.parseToDtoList(dictItemList, dictItemDtoList);
			pageDto.setPageData(dictItemDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		} catch (Exception e) {
			resultDo.setResultDo(DictItemResult.FIND_FAILURE);
			logger.error(DictItemResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}

	/**
	 * 字典项分页展示初始化
	 */
	@Override
	public ResultDo<Map<String, Object>> initItemMap(PageDto<DictItemDto> pageDto, DictItemDto dictItemDto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<DictItemDto> dictItemDtoList = new ArrayList<DictItemDto>();
		ResultDo<Map<String, Object>> resultDo = new ResultDo<Map<String, Object>>();
		List<DictItem> dictItemList = null;
		try {
			pageDto.setTotalRecord(dictItemMapper.selectCount(null));
			PageHelper.startPage(pageDto.getPageCurrent(), pageDto.getPageSize());
			dictItemList = dictItemMapper.selectAll();
			DictItemParseUtil.parseToDtoList(dictItemList, dictItemDtoList);
			pageDto.setPageData(dictItemDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		} catch (Exception e) {
			resultDo.setResultDo(DictItemResult.FIND_FAILURE);
			logger.error(DictItemResult.FIND_FAILURE.getValue(), e);
		}
		resultMap.put("dictItemList", pageDto);
		resultMap.put("dictTypeList", dictTypeService.selectAllType().getResultData());
		resultDo.setResultData(resultMap);
		return resultDo;
	}

	/**
	 * 查询字典项根据type和state
	 */
	@Override
	public ResultDo<List<DictItemDto>> findByTypeCode(String typeCode) {
		List<DictItemDto> dictItemDtoList = new ArrayList<DictItemDto>();
		ResultDo<List<DictItemDto>> resultDo = new ResultDo<List<DictItemDto>>();
		List<DictItem> dictItemList = null;
		try {
			dictItemList = dictItemMapper.selectByTypeCode(typeCode);
			DictItemParseUtil.parseToDtoList(dictItemList, dictItemDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());

		} catch (Exception e) {
			resultDo.setResultDo(DictItemResult.FIND_FAILURE);
			logger.error(DictItemResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(dictItemDtoList);
		return resultDo;
	}

	@Override
	public void refreshDictCache() {
		ResultDo<List<DictTypeDto>>  dictTypeDtoListResultDo = dictTypeService.selectAllType();
		if(InterfaceResult.SUCCESS.getKey().equals(dictTypeDtoListResultDo.getResultCode())) {
			if(null!=dictTypeDtoListResultDo.getResultData()&&!dictTypeDtoListResultDo.getResultData().isEmpty()) {
				Map<String,String> dictTypeMap = null;
				for(DictTypeDto dictTypeDto:dictTypeDtoListResultDo.getResultData()) {
					List<DictItem> dictItemList = dictItemMapper.selectByTypeCode(dictTypeDto.getTypeCode());
					if(null!=dictItemList&&!dictItemList.isEmpty()) {
//						dictTypeMap = RedisUtil.getInstance().getMap(dictTypeDto.getTypeCode());
						if(null==dictTypeMap){
//							logger.debug("字典类型不存在，新增字典类型，字典类型Code：《" + dictTypeDto.getTypeCode() + "》，字典类型Name：《"+ dictTypeDto.getTypeName() + "》");
							dictTypeMap = new HashMap<String,String>();
						}
						for (DictItem dictItemDto : dictItemList) {
//							RedisUtil.getInstance().setStr(dictTypeDto.getTypeCode() + "-" + dictItemDto.getItemCode(), dictItemDto.getItemValue());
//							logger.debug("字典项Code：《" + dictTypeDto.getTypeCode() + "-" + dictItemDto.getItemCode() + "》，字典项value：《"+ dictItemDto.getItemValue() + "》");
							dictTypeMap.put(dictItemDto.getItemValue(), dictItemDto.getItemName());
						}
//						logger.debug("更新字典类型，字典类型Code：《" + dictTypeDto.getTypeCode() + "》，字典类型Name：《"+ dictTypeDto.getTypeName() + "》");
//						RedisUtil.getInstance().setMap(dictTypeDto.getTypeCode(), dictTypeMap);
					}
				}
			}
		}
	}

}