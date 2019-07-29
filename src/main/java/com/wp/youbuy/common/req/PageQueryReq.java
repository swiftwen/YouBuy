package com.wp.youbuy.common.req;

import java.io.Serializable;

/**
 * 
 * @author swiftwen
 * @date 2019年7月29日 上午11:09:24
 */
public class PageQueryReq implements Serializable {

	private static final long serialVersionUID = -3740303179598326126L;

	private Integer pageNum;

	private Integer pageSize;

	public PageQueryReq() {
	}

	public PageQueryReq(PageQueryReq req) {
		this.pageNum = req.getPageNum() == null ? 0 : req.getPageNum();
		this.pageSize = req.getPageSize();
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public static Integer getStart(PageQueryReq req) {
		if (req == null || req.getPageSize() == null || req.getPageNum() == null || req.getPageSize() <= 0
				|| req.getPageNum() < 0) {
			return null;
		}
		return (req.pageNum - 1) * req.getPageSize();
	}
}
