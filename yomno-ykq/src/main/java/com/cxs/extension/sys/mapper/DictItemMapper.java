package com.cxs.extension.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cxs.extension.core.utils.CoreMapper;
import com.cxs.extension.sys.entity.DictItem;

/**
 * 
 * @Description: 字典项数据库操作封装类
 * @ClassName: DictItemMapper 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年05月25日
 *
 */
public interface DictItemMapper extends CoreMapper<DictItem> {

	/**
	 * 根据id列表删除字典项
	 * @param ids id列表
	 */
	@Delete("delete from sys_dict_item where id in (${ids})")
	void deleteByIds(@Param("ids") String ids);
	/**
	 * 查询字典项根据type和state
	 * @param typeCode
	 * @return
	 */
	@Select("select item_code as itemCode , item_value as itemValue ,item_name as itemName from sys_dict_item  where type_code=#{typeCode} and state = 1 order by scort")
	List<DictItem> selectByTypeCode(@Param("typeCode") String typeCode);
	/**
	 * 查询新增字典项是否存在
	 * @param typeCode 字典类型编码
	 * @param itemCode 字典项编码
	 * @param scort 字典项排序
	 * @return
	 */
	@Select("select * from sys_dict_item where type_code=#{typeCode} and (item_code = #{itemCode} or scort = #{scort}) ")
	DictItem selectByTypeCodeAndCodeOrScort(@Param("typeCode") String typeCode,@Param("itemCode") String itemCode,@Param("scort") Long scort);
	/**
	 * 查询修改字典项是否存在
	 * @param id id
	 * @param typeCode 字典类型编码
	 * @param itemCode 字典项编码
	 * @param scort 字典项排序
	 * @return
	 */
	@Select("select * from sys_dict_item where id<>#{id} and type_code=#{typeCode} and (item_code = #{itemCode} or scort = #{scort})")
	DictItem selectByIdAndTypeCodeAndCodeOrScort(@Param("id") String id,@Param("typeCode") String typeCode,@Param("itemCode") String itemCode,@Param("scort") Long scort);
	
}
