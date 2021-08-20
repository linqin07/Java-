package 接口报文封装;

import java.io.IOException;

import net.sf.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

import fastjson.fastjson;
import gson.HCJson;

public class Test {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		RequestHeader header = new RequestHeader();
		header.security = "none";
		header.channelType = "5";
		header.transType = "N";
		
		ApiRequest request = new ApiRequest();
		request.set("id", "1");
		request.set("name", "linqin");
		request.set("pwd", "kkksss");
		
		request.header = header;
		
		/**
		 * 复杂对象：由一个头部，public的构成。body由hashmap构成：能用 jackjson转化了,gson也可以
		 * 给public里面的属性getset后jsonlib也可以转化
		 * 但是jsonfast还是不行。
		 * 
		 * 
		 */
		
		
		System.out.println(JSON.toJSONString(request.body));
		
		/** jsonlib */
		String jsonlib = JSONObject.fromObject(request).toString();
		Object bean = JSONObject.toBean(JSONObject.fromObject(request), ApiRequest.class);
		System.out.println(bean.toString());
		
		/** gson */
		String json = HCJson.toString(request);
		ApiRequest object = HCJson.toObject(json, ApiRequest.class);
		System.out.println(object.toString());
	}

}
