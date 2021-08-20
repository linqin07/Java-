package 字符串操作拼接移除;

import com.google.common.base.Splitter;
import com.google.common.collect.*;

import java.util.*;

/**
 * @Description:
 * @author: LinQin
 * @date: 2018/10/26
 */
public class GuavaTest {
    public static void main(String[] args) {
        //新建list，map，set
        ArrayList<String> list = Lists.newArrayList();
        HashMap<Object, Object> map = Maps.newHashMap();
        HashSet<Object> set = Sets.newHashSet();

        //不可变集合，一次定义就final了。
        ImmutableList<String> of = ImmutableList.of("1", "2", "3");
        ImmutableMap<String, String> map1 = ImmutableMap.of("key1", "value1", "key2", "value2");
        map.put("key3", "value3");
        // [key1=value1, key2=value2]
        System.out.println(map1.entrySet());


        List<String> list1 = Splitter.on(",").splitToList("");
        System.out.println();
    }
}
