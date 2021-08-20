package 获取系统信息;

import org.apache.commons.lang.SystemUtils;

/**
 * @Description:
 * @author: LinQin
 * @date: 2018/12/14
 */
public class SystemUtilsTest {
    public static void main(String[] args) {
        System.out.println(SystemUtils.IS_OS_LINUX);
        System.out.println(SystemUtils.IS_OS_MAC);
        System.out.println(SystemUtils.IS_OS_WINDOWS);

        // 获取系统位数
        System.out.println(SystemUtils.OS_ARCH);



    }
}
