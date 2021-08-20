package 接口报文封装;

import java.util.Date;
/**
 * API接口报文响应头部信息
 * @author zhangyu
 */
public class ResponseHeader {
	/** 版本号 */
	public String version;
	/** 安全模式 */
	public String security;
	/** 接口类型 */
	public String transtype;
	/** 服务端时间戳 */
	public String dtserver;
	
	public ResponseHeader(){
		dtserver = new Date().toLocaleString();
		version = "100";
		security="none";
	}
}

