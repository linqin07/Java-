package guava;

import com.google.common.base.Optional;
import com.google.common.cache.*;
import com.google.common.graph.Graph;
import jdk.nashorn.internal.runtime.options.Options;

import java.security.Key;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author: LinQin
 * @date: 2019/05/14
 */
public class GuavaCache {
    public static Cache<String, Object> cache;

    static {
        // removeListener 从缓存中移除，调用这个方法
        // initialCapacity 初始化容量
        // concurrentLevel 并发的线程数
        // expireAfterWrite 写入多长时间后，失效
        cache = CacheBuilder.newBuilder()
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
                        System.out.println("remove  " + removalNotification.getKey() + ":" + removalNotification.getValue());
                    }
                })
                .initialCapacity(30)
                .concurrencyLevel(5)
                .expireAfterWrite(20, TimeUnit.MINUTES)
                .build();
        //手动加载数据
        cache.put("1", "name11");
        cache.put("2", "name12");
        cache.put("3", "name13");
        cache.put("4", "name14");
        cache.put("5", "name15");
        cache.put("6", "name16");
    }


    public static void main(String[] args) throws ExecutionException {
        //获取一个不存在的key
        System.out.println("------------------");
        System.out.println(cache.getIfPresent("7'") == null);
        //获取一个存在的key
        System.out.println(cache.getIfPresent("1"));
        //获取一个不存在的key，自己定义一个加载方法
        System.out.println(cache.get("7", new Callable() {
            @Override
            public Object call() throws Exception {
                //返回值，一定不能为null
                return "dadad";
            }
        }));
        System.out.println(cache.getIfPresent("7"));
        cache.invalidate("1");

        System.out.println(cache.getIfPresent("1"));

        System.out.println("------------------");

        

    }
}
