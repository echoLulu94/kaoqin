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

import com.cxs.extension.sys.dto.DictTypeDto;
import com.cxs.extension.sys.entity.DictType;
import com.cxs.extension.sys.mapper.DictTypeMapper;
import com.cxs.extension.sys.result.DictTypeResult;
import com.cxs.extension.sys.service.api.DictTypeService;
import com.cxs.extension.sys.utils.DictTypeParseUtil;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;
import com.cxs.framework.result.InterfaceResult;
import com.cxs.framework.utils.IdUtil;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

/**
 * 
 * @Description: 字典类型业务处理实现类
 * @ClassName: DictTypeServiceImpl
 * @author: ryan.guo
 * @email: chinazan@qq.com
 * @date: 2017年05月25日
 *
 */
@Service
public class DictTypeServiceImpl implements DictTypeService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DictTypeMapper dictTypeMapper;

	/**
	 * 新增保存
	 */
	@Override
	public ResultDo<DictTypeDto> saveDictType(DictTypeDto dictTypeDto) {
		ResultDo<DictTypeDto> resultDo = new ResultDo<DictTypeDto>();
		DictType dictType = new DictType();
		/*系统当前时间*/
		long time = System.currentTimeMillis();
		try {
			if (null != dictTypeDto) {
				if (null != dictTypeDto.getTypeCode()) {
					DictType dictTypeTmp = dictTypeMapper.selectByCode(dictTypeDto.getTypeCode());
					if (null != dictTypeTmp) {
						resultDo.setResultDo(DictTypeResult.SAVE_CODE_EXISTS);
						logger.error(DictTypeResult.SAVE_CODE_EXISTS.getValue());
					} else {
						dictTypeDto.setId(IdUtil.getUuid());
						dictTypeDto.setCreateTime(time);
						dictTypeDto.setUpdateTime(time);
						DictTypeParseUtil.parseToEntity(dictTypeDto, dictType);
						dictTypeMapper.insert(dictType);
						resultDo.setResultDo(InterfaceResult.SUCCESS);
						logger.info(InterfaceResult.SUCCESS.getValue());
					}
				} else {
					resultDo.setResultDo(DictTypeResult.SAVE_TYPECODE_NOT_NULL);
					logger.error(DictTypeResult.SAVE_TYPECODE_NOT_NULL.getValue());
				}
			} else {
				resultDo.setResultDo(DictTypeResult.SAVE_FAILURE);
				logger.error(DictTypeResult.SAVE_FAILURE.getValue());
			}
		} catch (Exception e) {
			resultDo.setResultDo(DictTypeResult.SAVE_FAILURE);
			logger.error(DictTypeResult.SAVE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(dictTypeDto);
		return resultDo;
	}

	@Override
	public ResultDo<String> deleteDictTypeById(String id) {
		ResultDo<String> resultDo = new ResultDo<String>();
		try {
			if (null != id && !"".equals(id)) {
				dictTypeMapper.deleteItemById(id);
				int i = dictTypeMapper.deleteByPrimaryKey(id);	
				if (i == 0) {
					resultDo.setResultDo(DictTypeResult.DELETE_DICTTYPE_NOT_EXIST);
					logger.error(DictTypeResult.DELETE_DICTTYPE_NOT_EXIST.getValue());
				} else {
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
				}

			} else {
				resultDo.setResultDo(DictTypeResult.DELETE_ID_NOT_NULL);
				logger.error(DictTypeResult.DELETE_ID_NOT_NULL.getValue());
			}
		} catch (Exception e) {
			resultDo.setResultDo(DictTypeResult.DELETE_FAILURE);
			logger.error(DictTypeResult.DELETE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(id);
		return resultDo;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<String[]> deleteDictTypeByIds(String[] ids) throws Exception {
		ResultDo<String[]> resultDo = new ResultDo<String[]>();
		try {
			if (null != ids && ids.length > 0) {
				for (String shortIds : IdUtil.getIdsList(ids)) {
					dictTypeMapper.deleteItemByIds(shortIds);
					dictTypeMapper.deleteByIds(shortIds);
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
				}
			} else {
				resultDo.setResultDo(DictTypeResult.DELETE_IDS_NOT_NULL);
				logger.error(DictTypeResult.DELETE_IDS_NOT_NULL.getValue());
			}
		} catch (Exception e) {
			resultDo.setResultDo(DictTypeResult.DELETE_BY_IDS_FAILURE);
			logger.error(DictTypeResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(ids);
		return resultDo;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ResultDo<List<String>> deleteDictTypeByIdList(List<String> idList) throws Exception {
		ResultDo<List<String>> resultDo = new ResultDo<List<String>>();
		try {
			if (null != idList && !idList.isEmpty()) {
				for (String shortIds : IdUtil.getIdsList(idList)) {
					dictTypeMapper.deleteByIds(shortIds);
					resultDo.setResultDo(InterfaceResult.SUCCESS);
					logger.info(InterfaceResult.SUCCESS.getValue());
				}
			} else {
				resultDo.setResultDo(DictTypeResult.DELETE_IDS_NOT_NULL);
				logger.error(DictTypeResult.DELETE_IDS_NOT_NULL.getValue());
			}
		} catch (Exception e) {
			logger.error(DictTypeResult.DELETE_BY_IDS_FAILURE.getValue(), e);
			throw e;
		}
		resultDo.setResultData(idList);
		return resultDo;
	}

	/**
	 * 修改保存
	 */
	@Override
	public ResultDo<DictTypeDto> updateDictType(DictTypeDto dictTypeDto) {
		ResultDo<DictTypeDto> resultDo = new ResultDo<DictTypeDto>();
		DictType dictType = new DictType();
		/*系统当前时间*/
		long time = System.currentTimeMillis();
		try {
			if (null != dictTypeDto) {
				if (null != dictTypeDto.getId()) {
					if (null != dictTypeDto.getTypeCode()) {
						DictType dictTypeTmp = dictTypeMapper.selectByIdAndCode(dictTypeDto.getId(), dictTypeDto.getTypeCode());
						if (null != dictTypeTmp) {
							resultDo.setResultDo(DictTypeResult.UPDATE_CODE_EXISTS);
							logger.error(DictTypeResult.UPDATE_CODE_EXISTS.getValue());
						} else {
							dictTypeDto.setUpdateTime(time);
							DictTypeParseUtil.parseToEntity(dictTypeDto, dictType);
							dictTypeMapper.updateItemByPrimaryKeySelective(dictType);
							dictTypeMapper.updateByPrimaryKeySelective(dictType);
							resultDo.setResultDo(InterfaceResult.SUCCESS);
							logger.info(InterfaceResult.SUCCESS.getValue());
						}
					} else {
						resultDo.setResultDo(DictTypeResult.UPDATE_TYPECODE_NOT_NULL);
						logger.error(DictTypeResult.UPDATE_TYPECODE_NOT_NULL.getValue());
					}
				} else {
					resultDo.setResultDo(DictTypeResult.UPDATE_ID_NOT_NULL);
					logger.error(DictTypeResult.UPDATE_ID_NOT_NULL.getValue());
				}
			} else {
				resultDo.setResultDo(DictTypeResult.UPDATE_FAILURE);
				logger.error(DictTypeResult.UPDATE_FAILURE.getValue());
			}
		} catch (Exception e) {
			resultDo.setResultDo(DictTypeResult.UPDATE_FAILURE);
			logger.error(DictTypeResult.UPDATE_FAILURE.getValue(), e);
		}
		resultDo.setResultData(dictTypeDto);
		return resultDo;
	}

	@Override
	public ResultDo<DictTypeDto> findDictTypeById(String id) {
		DictTypeDto dictTypeDto = new DictTypeDto();
		ResultDo<DictTypeDto> resultDo = new ResultDo<DictTypeDto>();
		try {
			if (null != id && !"".equals(id)) {
				DictType dictType = dictTypeMapper.selectByPrimaryKey(id);
				DictTypeParseUtil.parseToDto(dictType, dictTypeDto);
				resultDo.setResultDo(InterfaceResult.SUCCESS);
				logger.info(InterfaceResult.SUCCESS.getValue());
			} else {
				resultDo.setResultDo(DictTypeResult.FIND_BY_ID_NOT_NULL);
				logger.error(DictTypeResult.FIND_BY_ID_NOT_NULL.getValue());
			}
		} catch (Exception e) {
			resultDo.setResultDo(DictTypeResult.FIND_FAILURE);
			logger.error(DictTypeResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(dictTypeDto);
		return resultDo;
	}

	@Override
	public ResultDo<PageDto<DictTypeDto>> findDictType(PageDto<DictTypeDto> pageDto) {
		logger.debug("debug test");
		List<DictTypeDto> dictTypeDtoList = new ArrayList<DictTypeDto>();
		List<DictType> dictTypeList = null;
		ResultDo<PageDto<DictTypeDto>> resultDo = new ResultDo<PageDto<DictTypeDto>>();
		try {
			pageDto.setTotalRecord(dictTypeMapper.selectCount(null));
			PageHelper.startPage(pageDto.getPageCurrent(), pageDto.getPageSize());
			dictTypeList = dictTypeMapper.selectAll();
			DictTypeParseUtil.parseToDtoList(dictTypeList, dictTypeDtoList);
			pageDto.setPageData(dictTypeDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		} catch (Exception e) {
			resultDo.setResultDo(DictTypeResult.FIND_FAILURE);
			logger.error(DictTypeResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}

	/**
	 * 根据查询条件分页查询字典类型对象
	 * 
	 * @param pageDto
	 *            分页对象
	 * @param dictTypeDto
	 *            查询条件
	 * @return
	 */
	@Override
	public ResultDo<PageDto<DictTypeDto>> findDictType(PageDto<DictTypeDto> pageDto, DictTypeDto dictTypeDto) {
		List<DictTypeDto> dictTypeDtoList = new ArrayList<DictTypeDto>();
		ResultDo<PageDto<DictTypeDto>> resultDo = new ResultDo<PageDto<DictTypeDto>>();
		List<DictType> dictTypeList = null;
		try {
			Example example = new Example(DictType.class);
			example.createCriteria();
			if (StringUtil.isNotEmpty(dictTypeDto.getTypeCode())) {
				example.getOredCriteria().get(0).andLike("typeCode", "%" + dictTypeDto.getTypeCode() + "%");
			}
			if (StringUtil.isNotEmpty(dictTypeDto.getTypeName())) {
				example.getOredCriteria().get(0).andLike("typeName", "%" + dictTypeDto.getTypeName() + "%");
			}
			pageDto.setTotalRecord(dictTypeMapper.selectCountByExample(example));
			DictType dictType = new DictType();
			PageHelper.startPage(pageDto.getPageCurrent(), pageDto.getPageSize());
			DictTypeParseUtil.parseToEntity(dictTypeDto, dictType);
			DictTypeParseUtil.parseToDtoList(dictTypeList, dictTypeDtoList);
			dictTypeList = dictTypeMapper.selectByExample(example);
			DictTypeParseUtil.parseToDtoList(dictTypeList, dictTypeDtoList);
			pageDto.setPageData(dictTypeDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());
		} catch (Exception e) {
			resultDo.setResultDo(DictTypeResult.FIND_FAILURE);
			logger.error(DictTypeResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(pageDto);
		return resultDo;
	}

	/**
	 * 分页字典类型初始化
	 * 
	 * @return
	 */
	@Override
	public ResultDo<Map<String, Object>> initTypeMap(PageDto<DictTypeDto> pageDto, DictTypeDto dictTypeDto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<DictTypeDto> dictTypeDtoList = new ArrayList<DictTypeDto>();
		ResultDo<Map<String, Object>> resultDo = new ResultDo<Map<String, Object>>();
		List<DictType> dictTypeList = null;
		try {
			pageDto.setTotalRecord(dictTypeMapper.selectCount(null));
			PageHelper.startPage(pageDto.getPageCurrent(), pageDto.getPageSize());
			dictTypeList = dictTypeMapper.selectAll();
			DictTypeParseUtil.parseToDtoList(dictTypeList, dictTypeDtoList);
			pageDto.setPageData(dictTypeDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());

		} catch (Exception e) {
			resultDo.setResultDo(DictTypeResult.FIND_FAILURE);
			logger.error(DictTypeResult.FIND_FAILURE.getValue(), e);
		}
		resultMap.put("dictTypeList", pageDto);
		resultDo.setResultData(resultMap);
		return resultDo;
	}
	/**
	 * 下拉框查询字典类型，字典项管理使用
	 * @return
	 */
	@Override
	public ResultDo<List<DictTypeDto>> selectAllType(){
		ResultDo<List<DictTypeDto>> resultDo = new ResultDo<List<DictTypeDto>>();
		List<DictTypeDto> dictTypeDtoList = new ArrayList<DictTypeDto>();
		List<DictType> dictTypeList = null;
		try {
			dictTypeList = dictTypeMapper.selectAllType();
			DictTypeParseUtil.parseToDtoList(dictTypeList, dictTypeDtoList);
			resultDo.setResultDo(InterfaceResult.SUCCESS);
			logger.info(InterfaceResult.SUCCESS.getValue());

		} catch (Exception e) {
			resultDo.setResultDo(DictTypeResult.FIND_FAILURE);
			logger.error(DictTypeResult.FIND_FAILURE.getValue(), e);
		}
		resultDo.setResultData(dictTypeDtoList);
		return resultDo;
	}
}
