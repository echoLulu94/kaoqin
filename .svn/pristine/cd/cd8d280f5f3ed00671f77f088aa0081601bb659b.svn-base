package com.cxs.extension.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cxs.extension.core.utils.CoreMapper;
import com.cxs.extension.sys.entity.DictType;

/**
 * 
 * @Description: 字典类型数据库操作封装类
 * @ClassName: DictTypeMapper 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日
 *
 */
public interface DictTypeMapper extends CoreMapper<DictType> {

	/**
	 * 根据id列表删除字典类型
	 * @param ids id列表
	 */
	@Delete("delete from sys_dict_type where id in (${ids})")
	void deleteByIds(@Param("ids") String ids);
	/**
	 * 根据字典类型编码查询
	 * @param typeCode 字典类型编码
	 * @return
	 */
	@Select("select * from sys_dict_Type where type_code=#{typeCode}")
	DictType selectByCode(@Param("typeCode") String typeCode);
	/**
	 * 下拉框查询字典类型
	 * @param typecode
	 * @return
	 */
	@Select("select type_code as typeCode ,type_name as typeName from sys_dict_type")
	List<DictType> selectAllType();
	/**
	 * 根据id和字典类型编码查询
	 * @param id id
	 * @param typeCode 字典类型编码
	 * @return
	 */
	@Select("select * from sys_dict_Type where id<>#{id} and type_code=#{typeCode}")
	DictType selectByIdAndCode(@Param("id") String id, @Param("typeCode") String typeCode);
	/**
	 * 修改字典项管理里的字典类型
	 * @param dictType
	 */
	@Update("update sys_dict_item set type_code=#{typeCode} , type_name=#{typeName} where type_code in (select type_code from sys_dict_type where id=#{id})")
	void updateItemByPrimaryKeySelective(DictType dictType);
	/**
	 * 单个删除字典项管理的字典类型
	 * @param id
	 */
	@Delete("delete from sys_dict_item where type_code = (select type_code from sys_dict_type where id=#{id})")
	void deleteItemById(@Param("id") String id);
	/**
	 * 根据id列表删除字典项管理的字典项
	 * @param ids id列表
	 */
	@Delete("delete from sys_dict_item where type_code in (select type_code from sys_dict_type where id in (${ids}))")
	void deleteItemByIds(@Param("ids") String ids);
}
