package 接口报文封装;

import java.util.Date;

/**
 * API接口报文请求头部信息
 * @author zhangyu
 */
@SuppressWarnings({"ALL", "unused"})
public class RequestHeader {
	/** 版本号 */
	public String version;
	/** 安全模式 */
	public String security;
	/** 接口类型 */
	public String transType;
	/** 客户端时间戳 */
	public String dtClient;
	/** 渠道类型 */
	public String channelType;
	
	public RequestHeader(){
		version = "100";
		dtClient = new Date().toLocaleString();
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getDtClient() {
		return dtClient;
	}

	public void setDtClient(String dtClient) {
		this.dtClient = dtClient;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	
	
}

