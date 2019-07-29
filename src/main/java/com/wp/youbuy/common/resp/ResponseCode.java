package com.wp.youbuy.common.resp;
/**
 * 
 * @author swiftwen
 * @date 2019年7月29日 上午11:09:05
 */
public enum ResponseCode {

	SUCCESS_DEFAULT(0), SUCCESS(0, ""), FAIL(-1, "操作失败"), PAGE_QUERY_INVALID(-2, "分页参数为空或数据格式不正确"), SERVER_ERROR(500,
			"服务器错误");

	final private int code;
	final private String msg;

	ResponseCode(int code) {
		this.code = code;
		this.msg = "";
	}

	ResponseCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
