package com.wp.youbuy.common.resp;


import java.io.Serializable;

import com.wp.youbuy.common.req.PageQueryReq;

/**
 * 
 * @author swiftwen
 * @date 2019年7月29日 上午11:08:30
 */
public class PageQueryResp extends PageQueryReq implements Serializable{
    private static final long serialVersionUID = 4153890730113987572L;
   
    private Integer totalCount;
    
    private Integer pageTotalCount;

    public PageQueryResp(){}

    public PageQueryResp(PageQueryReq pageQueryReq,int totalCount){
        super(pageQueryReq);
        this.totalCount=totalCount;
        if(pageQueryReq.getPageSize()!=null&&pageQueryReq.getPageSize()>0){
            pageTotalCount = (int) Math.ceil((double) totalCount / pageQueryReq.getPageSize());
        }
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }
}
