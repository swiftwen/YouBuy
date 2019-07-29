package com.wp.youbuy.common.resp;

/**
 * 
 * @author swiftwen
 * @date 2019年7月29日 上午11:08:24
 */
public class BaseResponseCreator {
    public BaseResponse create(Object data){
        return new BaseResponse(ResponseCode.SUCCESS, data);
    }
}
