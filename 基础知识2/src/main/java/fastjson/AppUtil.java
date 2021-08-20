package fastjson;

import org.apache.commons.lang.StringUtils;

/**
 * @Description:
 * @author: LinQin
 * @date: 2019/05/22
 */
public class AppUtil {
    public static boolean isNullOrEmpty(String p) {
        return StringUtils.isNotEmpty(p);
    }
}
