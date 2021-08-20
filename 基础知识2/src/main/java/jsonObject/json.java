package jsonObject;

import fastjson.Group;
import jackson.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

public class json {
	public static void main(String[] args) {
		System.out.println("java代码封装为json字符串");
		//创建JsonObject第一种方法  
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("username", "张三");
		jsonObj.put("password", "");
		jsonObj.element("element", "element");
		//创建JsonObject第二种方法  
		HashMap map=new HashMap();
		map.put("username", "张三");
		map.put("password", null);
		JSONObject jsonObj2 = JSONObject.fromObject(map);
		System.out.println("java--->json \n" + jsonObj2.toString());
		//直接对象转化
		User user=new User();
		user.setId(11);
		user.setUsername("linqin");
		
		JSONObject jsonObject3 = JSONObject.fromObject(user);
		System.out.println(jsonObject3);
		//toBean
		User bean = (User) JSONObject.toBean(jsonObject3, User.class);
		System.out.println(bean.toString());

	}
}
