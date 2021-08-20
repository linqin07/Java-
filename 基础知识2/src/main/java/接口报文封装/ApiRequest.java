package 接口报文封装;


import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONObject;



/**
 * API接口报文请求通用数据载体
 * @author zhangyu
 */
public class ApiRequest {
	
	/** 报文请求头部信息 */
	public RequestHeader header = new RequestHeader();
	
	/** 报文请内容信息 */
	public HashMap<String, Object> body = new HashMap<String,Object>();
	
    /**
     * 返回此对象所标识的json字符串
     */
    @Override
    public String toString() {
    	ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (Exception e) {
			throw new RuntimeException("对象转json字符串出错, " + e.getMessage() , e);
		} 
    }
	/**
     * 根据key获取字符串内容,已去空格
     * @param key
     * @return
     */
    public String getString(String key){
    	String temp = (String) body.get(key); 
    	return temp == null ? temp : temp.trim();
    }
    
    public Object get(String key){
    	return body.get(key);
    }
    
    /**
     * 设置body内容
     * @param key
     * @param obj
     */
    public void set(String key, String value){
    	body.put(key, value);
    }
	public RequestHeader getHeader() {
		return header;
	}
	public void setHeader(RequestHeader header) {
		this.header = header;
	}
	public HashMap<String, Object> getBody() {
		return body;
	}
	public void setBody(HashMap<String, Object> body) {
		this.body = body;
	}
}
