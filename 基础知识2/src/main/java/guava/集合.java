package guava;

import com.google.common.base.Joiner;
import com.google.common.collect.*;
import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: LinQin
 * @date: 2019/05/14
 */
public class 集合 {
    public static void main(String[] args) {
        // 不可变集合
        ImmutableSet<String> color_names = ImmutableSet.of("red", "orange", "yellow", "green", "blue", "purple");

        ImmutableList<String> of = ImmutableList.of("1", "2");
        // builder
        ImmutableList.builder().add("1", "2", "3").addAll(of).build();
        // copyOf
        ImmutableList<String> strings = ImmutableList.copyOf(of);

        // jdk中的不可变集合。
        Collections.unmodifiableList(Lists.newArrayList());

/*****************************************************************************/
        String[] str = new String[]{"a", "a", "b"};
        Multiset<String> multiset = HashMultiset.create();
        // multiset.addAll(Arrays.asList(str));
        multiset.add("a");
        multiset.add("a");
        multiset.add("a");
        multiset.add("c");
        multiset.add("c");
        multiset.add("c");
        multiset.add("c");
        multiset.add("b");
        multiset.add("b");

        for (Multiset.Entry item : multiset.entrySet()) {
            System.out.println(item.getElement() + "=" + item.getCount());
        }
        // 转为set，去重复
        Set<String> strings1 = multiset.elementSet();
        System.out.println(strings1);

        /*****************************************************************************/
        HashMultimap<String, Object> map = HashMultimap.create();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", "");


        // guava集合去空记录
        List<String> gg = Lists.newArrayList();
        gg.add("");
        gg.add("");
        gg.add("kjlj1");
        gg.removeIf(item -> StringUtils.isEmpty(item));
        System.err.println(Joiner.on(",").join(gg));

        // jdk1.8去空集合记录
        List<String> collect = gg.stream().filter(item -> {
            return !StringUtils.isEmpty(item);
        }).collect(Collectors.toList());
        System.err.println(Joiner.on(",").join(collect));

        //
        gg.removeAll(Collections.singleton(""));
        System.err.println(gg.toString());

        // List<String> ggg = null;
        // System.out.println(Joiner.on(",").join(ggg));

        // Exception: null value in entry: k=null 报错,ps ImmutableMap value不能为null
        // ImmutableMap<String, Object> k = ImmutableMap.of("k", null);
        // System.out.println(k.entrySet());

        HashMap<Object, Object> objectObjectHashMap = Maps.newHashMap();
        objectObjectHashMap.put("k", null);
        System.out.println(objectObjectHashMap.entrySet());


        if (new Date(1614837817000L).before(new Date())) {
            System.out.println("ggg");
        }

        String[] s = "so_ut".split("_");
        System.out.println();
    }
}
