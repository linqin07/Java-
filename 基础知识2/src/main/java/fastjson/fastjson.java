package fastjson;

import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class fastjson {

	public static void main(String[] args) {
		Group group = new Group();
		group.setId(0L);
		group.setName("admin");
		
		User guestUser = new User();
		guestUser.setId(2L);
		guestUser.setName("guest");

		User rootUser = new User();
		rootUser.setId(3L);
//		rootUser.setName(null);
		
		group.getUsers().add(guestUser);
		group.getUsers().add(rootUser);
		
		String fastJson=JSON.toJSONString(group);
		System.out.println(fastJson);
		
		//Decode
		Group group1 = JSON.parseObject(fastJson,Group.class);
		System.out.println(group1.toString());
		
		
	}

}
