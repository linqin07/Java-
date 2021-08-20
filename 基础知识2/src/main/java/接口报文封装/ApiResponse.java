package 接口报文封装;


import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONObject;



/**
 * API接口报文响应通用数据载体
 * @author zhangyu
 */
public class ApiResponse {

	/** 报文响应头部信息 */
	public ResponseHeader header = new ResponseHeader();

	/** 报文响应内容信息 */
	public HashMap<String, Object> body = new HashMap<String, Object>();
	
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
     * 根据key获取字符串内容
     * @param key
     * @return
     */
    public String getString(String key){
    	return String.valueOf(body.get(key));
    }
    
    public ApiResponse setCodeAndMessage(String code,String message){
    	this.set("code", code);
    	this.set("message", message);
    	return this;
    }
    
    /**
     * 设置body内容
     * @param key
     * @param obj
     */
    public void set(String key, Object value){
    	body.put(key, value);
    }
}
