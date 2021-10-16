import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        final String regex = "(?<=select)(.|\\s)+?(?=from)";
        final String string = "select timestamp,  \n"
                + "sum(if(availableZone='sandun',cnt,0)) \"sandun\",       \n"
                + "sum(if(availableZone='shiqiao',cnt,0)) \"shiqiao\", \n"
                + "sum(if(availableZone='hd',cnt,0)) \"hd\", \n"
                + "sum(if(availableZone='',cnt,0)) \"未知\", \n"
                + "sum(cnt) \"调用总量\" \n"
                + "from \n"
                + "(select JSONExtractString(tags,'availableZone') availableZone, toStartOfMinute(toDateTime(clock/1000)) timestamp, sum(value) cnt from snc_aiops_performance.test where metricCode = 'gateway_esb_counts' group by availableZone, timestamp ) group by timestamp order by timestamp\n\n\n"
                + "select * from xxx\n"
                + "select aa,bb c,cc from xxx where \n\n"
                + "select times from xx";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(string);

        // 匹配，一般判断是否为某种类型
        if (matcher.matches()) {
            for (int i = 0; i < matcher.groupCount(); i++) {
                System.out.println(matcher.group(i));
            }
        }
        // 查找，能匹配出来多个, group0 表示完全匹配，group1是完全匹配里面的一部分，可能还有多部分
        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));

            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
            System.out.println("==========");
        }
    }
}
