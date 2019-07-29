package com.wp.youbuy.controller;

import com.wp.youbuy.common.req.BaseRequest;

/**
 * 
 * @author swiftwen
 * @date 2019年7月29日 上午11:26:55
 */
public class BaseController {

	ThreadLocal<BaseRequest> baseRequestThreadLocal = new ThreadLocal<BaseRequest>();

	public BaseRequest getBaseRequest() {
		return baseRequestThreadLocal.get();
	}

	public void setBaseRequest(BaseRequest baseRequest) {
		baseRequestThreadLocal.set(baseRequest);
	}

	public void clearBaseRequest() {
		baseRequestThreadLocal.remove();
	}

}
