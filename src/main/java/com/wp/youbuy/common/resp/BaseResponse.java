package com.wp.youbuy.common.resp;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author swiftwen
 * @date 2019年7月29日 上午11:08:17
 */
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = -5555873589143384502L;

    private String            msg;
    private int               code;
    private T                 data;

    public static class Empty {
    }

    public BaseResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;

    }

    public void setData(T data) {
		this.code = ResponseCode.SUCCESS.getCode();
		this.msg = ResponseCode.SUCCESS.getMsg();
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return code == 0;
    }

    @JsonIgnore
    public boolean isNotNullOrEmpty() {
        return code == 0&&data!=null;
    }

    @JsonIgnore
    public boolean dataIsNull() {
        return data==null;
    }

    public static class EmptyData {

    }

    public BaseResponse() {
    }

    public BaseResponse(String msg) {
        this.msg=msg;
    }

    public BaseResponse(ResponseCode responseCode, T data) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.data = data;
    }

    public BaseResponse(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
    }

    public BaseResponse(T data) {
        this.code = ResponseCode.SUCCESS.getCode();
        this.msg = ResponseCode.SUCCESS.getMsg();
        this.setData(data);
    }

	@Override
	public String toString() {
		return "BaseResponse [msg=" + msg + ", code=" + code + ", data=" + data + "]";
	}
    
}
