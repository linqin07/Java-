package guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;

/**
 * @Description: 布隆过滤器
 * 原理：一个集合｛x,y,z｝ 分别计算每个的 hash 值存放到结果集，和比较值 z 的 hash 值比较。
 * 如果结果集不包含，则肯定不包含。如果结果包含，可能有。
 * @author: LinQin
 * @date: 2019/09/23
 */
public class BlooomFilter {
    public static void main(String[] args) {
    }
}
