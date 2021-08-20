package System.getProterty;

import com.sun.management.OperatingSystemMXBean;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author: LinQin
 * @date: 2018/12/11
 */
public class Test {
    private static OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("file.separator"));
        System.out.println(System.getProperty("line.separator"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("java.version"));

        // System.setProperty("key", "value");
        System.out.println(System.getProperty("key", "meiyou"));

        Map<String, String> getenv = System.getenv();
        System.out.println(getenv.entrySet());

        String string = "1212/";
        String s = string.endsWith("/") ? string.substring(0,string.length() - 1) : string;
        System.out.println(s);

        OperatingSystemMXBean operatingSystemMXBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory
                .getOperatingSystemMXBean();
        System.out.println(getProcessCpuLoad());
        System.out.println("------");
        System.out.println(memoryLoad());
        System.out.println(cpuLoad());
    }

    public static double getProcessCpuLoad() throws Exception {

        MBeanServer mbs    = ManagementFactory.getPlatformMBeanServer();
        ObjectName name    = ObjectName.getInstance("java.lang:type=OperatingSystem");
        AttributeList list = mbs.getAttributes(name, new String[]{ "ProcessCpuLoad" });

        if (list.isEmpty())     return Double.NaN;

        Attribute att = (Attribute)list.get(0);
        Double value  = (Double)att.getValue();

        // usually takes a couple of seconds before we get real values
        if (value == -1.0)      return Double.NaN;
        // returns a percentage value with 1 decimal point precision
        return ((int)(value * 1000) / 10.0);
    }

    public static int memoryLoad() {
        double totalvirtualMemory = osmxb.getTotalPhysicalMemorySize();
        double freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();

        double value = freePhysicalMemorySize/totalvirtualMemory;
        int percentMemoryLoad = (int) ((1-value)*100);
        return percentMemoryLoad;

    }
    public static int cpuLoad() {
        double cpuLoad = osmxb.getSystemCpuLoad();
        int percentCpuLoad = (int) (cpuLoad * 100);
        return percentCpuLoad;

    }

}
