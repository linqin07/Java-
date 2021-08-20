package guava;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

/**
 * @Description:
 * @author: LinQin
 * @date: 2020/07/14
 */
public class GuavaCollectTest {
    public static void main(String[] args) {
        ImmutableList<Integer> olds = ImmutableList.of(1, 2, 3);
        ImmutableList<Integer> news = ImmutableList.of(2, 3, 4);

        // 差集, A-B 的差集
        Sets.SetView difference = Sets.difference(Sets.newHashSet(olds), Sets.newHashSet(news));
        Sets.SetView difference1 = Sets.difference(Sets.newHashSet(news), Sets.newHashSet(olds));
        // 交集
        Sets.SetView and = Sets.intersection(Sets.newHashSet(news), Sets.newHashSet(olds));
        System.out.println(difference1.immutableCopy().asList());

        Sets.SetView union = Sets.union(Sets.newHashSet(news), Sets.newHashSet(olds));
        System.out.println(union.immutableCopy().asList());
    }
}
