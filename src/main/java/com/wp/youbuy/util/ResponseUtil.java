package com.wp.youbuy.util;

import com.wp.youbuy.common.resp.BaseResponse;
/**
 * 
 * @author swiftwen
 * @date 2019年7月29日 上午11:09:41
 */
public class ResponseUtil {

	public static <T> BaseResponse<T> buildResp(T t) {
		BaseResponse<T> resultDto = new BaseResponse<T>();
		resultDto.setData(t);
		return resultDto;
	}
	public static <T> BaseResponse<T> buildDefinitionResp(T t, String msg, int code) {
		BaseResponse<T> resultDto = new BaseResponse<T>();
		resultDto.setData(t);
		resultDto.setMsg(msg);
		resultDto.setCode(code);
		return resultDto;
	}
}
