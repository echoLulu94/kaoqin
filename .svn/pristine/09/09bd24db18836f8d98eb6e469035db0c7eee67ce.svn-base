package com.cxs.framework.dto;

import java.io.Serializable;
import java.util.List;

import com.cxs.framework.enums.PageInitDataEnum;

/**
 * @ClassName: Page
 * @Description: TODO 分页对象
 * @author: ryan.guo
 * @email: chinazan@qq.com
 * @date: 2017年3月2日 下午4:02:45
 */
public class PageDto<T> implements Serializable {

	private static final long serialVersionUID = 8007944048337473098L;
	// 页码
	private Integer pageCurrent = new Integer(PageInitDataEnum.PAGE_CURRENT.getValue());
	// 默认每页显示记录数
	private Integer pageSize = new Integer(PageInitDataEnum.PAGE_SIZE.getValue());
	// 记录总数
	private Integer totalRecord = new Integer(PageInitDataEnum.TOTAL_RECORD.getValue());
	// 总页数
	private Integer totalPage = new Integer(PageInitDataEnum.TOTAL_PAGE.getValue());

	// 结果
	private List<T> pageData;

	public PageDto() {
	}

	public PageDto(Integer pageSize, Integer pageCurrent) {
		this.pageSize = pageSize;
		this.pageCurrent = pageCurrent;
	}

	public void addData(int totalRecord, List<T> pageData) {
		this.totalRecord = totalRecord;
//		底层查询页码超出最后一页，返回最后一页数据，不合理，由程序把返回数据设为空
		if(pageCurrent>totalPage){
			this.pageData=null;
		}else{
			this.pageData = pageData;
		}
	}

	public List<T> getPageData() {
		return pageData;
	}

	public void setPageData(List<T> pageData) {
//		底层查询页码超出最后一页，返回最后一页数据，不合理，由程序把返回数据设为空
		if(pageCurrent>totalPage){
			this.pageData=null;
		}else{
			this.pageData = pageData;
		}
	}

	/**
	 * @return Returns the totalPage.
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		if (totalRecord.intValue() <= 0) {
			this.totalPage = 0;
		} else {
			this.totalPage = ((totalRecord.intValue() - 1) / pageSize.intValue()) + 1;
		}
		this.totalRecord = totalRecord;
	}

	/**
	 * 获取开始查询索引
	 * 
	 * @return
	 */
	public Integer getStartIndex() {
		return (this.getPageCurrent() - 1) * this.getPageSize();
	}

}
