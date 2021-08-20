package guava;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Optional;

/**
 * @Description:
 * @author: LinQin
 * @date: 2019/10/09
 */
public class Test {
    public static void main(String[] args) throws UnknownHostException {

        String s = ",2";
        String[] split1 = s.split(",");
        System.out.println(Arrays.toString(split1));

        Iterable<String> split = Splitter.on(",").omitEmptyStrings().split(s);
        System.out.println(split.toString());

        // ***************
        final boolean[] flag = new boolean[1];
        System.out.println(flag[0]);

        ImmutableMap<String, String> map = ImmutableMap.of("x", "x", "uu", "uu");
        Optional.ofNullable(map)
                .filter(v -> v.containsKey("uu"))
                .map(item -> MapUtils.getDouble(map, "uu"))
                .ifPresent(i -> System.out
                .println(i));

        Double uu = MapUtils.getDouble(map, "uu");

    }
}
