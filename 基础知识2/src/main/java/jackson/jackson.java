package jackson;
import com.fasterxml.jackson.databind.JavaType;
import com.google.common.collect.Lists;

import com.fasterxml.jackson.databind.ObjectMapper;
import fastjson.Group;

import java.util.ArrayList;
import java.util.List;


public class jackson {

	public static void main(String[] args) throws Exception {
		User user=new User(1, "dsd");
		ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        System.out.println(json);

        User user2 = mapper.readValue(json, User.class);
        System.out.println(user2.toString());

        System.out.println("--------------------");


        //复杂对象测试
        User user1=new User(2, "dsdsdfasd");
        List<Object> list = Lists.newArrayList();
        list.add(user);
        list.add(user1);

        Group group = new Group();
        group.setId(111L);
        group.setName("复杂对象");
        group.setUsers(list);

        String multiJson = mapper.writeValueAsString(group);
        System.out.println(multiJson);

        Group group1 = mapper.readValue(multiJson, Group.class);
        System.out.println(group1.toString());

        System.out.println("----------------");
        //处理json集合情况。
        String listJson = mapper.writeValueAsString(list);
        System.out.println(listJson);

        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, User.class);
        List<User> multiList = mapper.readValue(listJson, javaType);
        System.out.println(multiJson.toString());
    }
}
