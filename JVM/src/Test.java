import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @Description:
 * @author: LinQin
 * @date: 2021/08/05
 */
public class Test {
    public static void main(String[] args) throws IOException {
        User user = null;
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            // new ObjectEscape().init();
            user =  new ObjectReturn().createUser();
        }
        long end = System.currentTimeMillis();
        System.out.println("cost: " + (end - start));

        System.out.println("==== APP  STARTED ====");
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String name = runtime.getName();
        System.out.println(name);
        System.out.println("Process ID: " + name.substring(0, name.indexOf("@")));
        System.in.read();
    }
}
