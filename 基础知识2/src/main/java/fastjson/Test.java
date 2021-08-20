package fastjson;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author: LinQin
 * @date: 2019/05/22
 */
public class Test {
    public static void main(String[] args) {
        List list = Lists.newArrayList();
        User user = new User();
        user.setId(0L);
        user.setName("lin");

        User user1 = new User();
        user1.setId(12L);
        user1.setName("linqqqq");

        list.add(user);
        list.add(user1);

        String x1 = JSON.toJSONString(list);
        System.out.println(x1);

        List list1 = Lists.newArrayList();
        Map map1 = Maps.newConcurrentMap();
        map1.put("id", 0L);
        map1.put("name", "lin");

        Map map2= Maps.newConcurrentMap();
        map2.put("id", 12L);
        map2.put("name", "linqqqq");
        list1.add(map1);
        list1.add(map2);
        String x = JSON.toJSONString(list1);
        System.out.println(x);

        List<User> users = JSON.parseArray(x1, User.class);
        List<Map> users1 = JSON.parseArray(x, Map.class);

        System.out.println(users);
        System.out.println(users1);
    }
}
