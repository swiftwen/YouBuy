package com.wp.youbuy.common.req;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * @author swiftwen
 * @date 2019年7月29日 上午11:09:12
 */
public class BaseRequest implements Serializable {

	private static final long serialVersionUID = 9074787518267374493L;
	private UserInfo userInfo;
	private CallerInfo callerInfo;
	private TerminalInfo terminalInfo;
	private String sessionKey;

	private Map<String, String> requestMap;

	private String requestJson;

	// 签名
	private String sign;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public CallerInfo getCallerInfo() {
		return callerInfo;
	}

	public void setCallerInfo(CallerInfo callerInfo) {
		this.callerInfo = callerInfo;
	}

	public TerminalInfo getTerminalInfo() {
		return terminalInfo;
	}

	public void setTerminalInfo(TerminalInfo terminalInfo) {
		this.terminalInfo = terminalInfo;
	}

	public String getRequestJson() {
		return requestJson;
	}

	public void setRequestJson(String requestJson) {
		this.requestJson = requestJson;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public static class UserInfo implements Serializable {
		private static final long serialVersionUID = 3047873759928122439L;

		private Long userId;
		/**
		 * account 表id
		 */
		// private Integer accountId;

		// private String adminName;
		// private String adminEmail;

		/**
		 * 来源 1-达飞 2-鑫诚达
		 */
		// private Integer source;

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		@Override
		public String toString() {
			return "UserInfo [userId=" + userId + "]";
		}

	}

	public static class TerminalInfo implements Serializable {

		private static final long serialVersionUID = 4547159565360645609L;
		private String imei;
		private String appversion;
		private String channel;
		/**
		 * 平台，1-ios 2-android 3-web
		 */
		private String platform;
		private String model;
		private String os;
		private String networkType;
		private String bb;

		/**
		 * 请求IP
		 */
		private String hostIp;
		/**
		 * 经度
		 */
		private String longitude;
		/**
		 * 纬度
		 */
		private String latitude;

		public String getImei() {
			return imei;
		}

		public void setImei(String imei) {
			this.imei = imei;
		}

		public String getAppversion() {
			return appversion;
		}

		public void setAppversion(String appversion) {
			this.appversion = appversion;
		}

		public String getChannel() {
			return channel;
		}

		public void setChannel(String channel) {
			this.channel = channel;
		}

		public String getPlatform() {
			return platform;
		}

		public void setPlatform(String platform) {
			this.platform = platform;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public String getOs() {
			return os;
		}

		public void setOs(String os) {
			this.os = os;
		}

		public String getNetwork_type() {
			return networkType;
		}

		public void setNetworkType(String networkType) {
			this.networkType = networkType;
		}

		public String getBb() {
			return bb;
		}

		public void setBb(String bb) {
			this.bb = bb;
		}

		public String getHostIp() {
			return hostIp;
		}

		public void setHostIp(String hostIp) {
			this.hostIp = hostIp;
		}

		public String getLongitude() {
			return longitude;
		}

		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}

		public String getLatitude() {
			return latitude;
		}

		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}

		@Override
		public String toString() {
			return "TerminalInfo [imei=" + imei + ", appversion=" + appversion + ", channel=" + channel + ", platform="
					+ platform + ", model=" + model + ", os=" + os + ", networkType=" + networkType + ", bb=" + bb
					+ ", hostIp=" + hostIp + ", longitude=" + longitude + ", latitude=" + latitude + "]";
		}

	}

	public static class CallerInfo implements Serializable {
		private static final long serialVersionUID = -1447768411055984108L;
		/**
		 * 唯一标记请求的ID，可以从web层生成，一直在各个dubbo模块传递
		 */
		private String traceId;
		/**
		 * 请求时间，到ms
		 */
		private Long reqTime;

		public String getTraceId() {
			return traceId;
		}

		public void setTraceId(String traceId) {
			this.traceId = traceId;
		}

		public Long getReqTime() {
			return reqTime;
		}

		public void setReqTime(Long reqTime) {
			this.reqTime = reqTime;
		}

		@Override
		public String toString() {
			return "CallerInfo [traceId=" + traceId + ", reqTime=" + reqTime + "]";
		}

	}

	public Map<String, String> getRequestMap() {
		return requestMap;
	}

	public void setRequestMap(Map<String, String> requestMap) {
		this.requestMap = requestMap;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@Override
	public String toString() {
		return "BaseRequest{" + "userInfo=" + userInfo + ", callerInfo=" + callerInfo + ", terminalInfo=" + terminalInfo
				+ ", sessionKey='" + sessionKey + '\'' + ", requestMap=" + requestMap + ", requestJson='" + requestJson
				+ '\'' + ", sign='" + sign + '\'' + '}';
	}
}
