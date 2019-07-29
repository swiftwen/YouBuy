package com.wp.youbuy.dto.req;

import java.io.Serializable;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.wp.youbuy.dto.resp.TbkItemGetResponse;

import lombok.Data;

@Data
public class TbkItemGetRequest extends BaseTaobaoRequest<TbkItemGetResponse> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	

	@Override
	public Class<TbkItemGetResponse> getResponseClass() {
		// TODO Auto-generated method stub
		return TbkItemGetResponse.class;
	}

	@Override
	public void check() throws ApiRuleException {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public String getApiMethodName() {
		// TODO Auto-generated method stub
		return "taobao.tbk.item.get";
	}



	private String fields;
	
	private String q;
	
	private String cat;
	
	private String itemloc;
	
	private String sort;
	
    private Boolean isTmall;
    private Boolean isOverseas;
    
    private Long startPrice;
    private Long endPrice;
    
    private Long startTkRate;
    private Long endTkRate;
	private Long platform;
	
	private Long pageNo;
	
	private Long pageSize;
	@Override
	public Map<String, String> getTextParams() {
		TaobaoHashMap txtParams = new TaobaoHashMap();
	    txtParams.put("fields", this.fields);
	    txtParams.put("q", this.q);
	    txtParams.put("cat", this.cat);
	    txtParams.put("itemloc", this.itemloc);
	    txtParams.put("sort", this.sort);
	    txtParams.put("isTmall", this.isTmall);
	    txtParams.put("isOverseas", this.isOverseas);
	    txtParams.put("startPrice", this.startPrice);
	    txtParams.put("endPrice", this.endPrice);
	    txtParams.put("startTkRate", this.startTkRate);
	    txtParams.put("endTkRate", this.endTkRate);
	    txtParams.put("platform", this.platform);
	    if (this.udfParams != null) {
	      txtParams.putAll(this.udfParams);
	    }
	    return txtParams;
	}
	
}
