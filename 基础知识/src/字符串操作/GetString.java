package 字符串操作;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetString {
    /**
     * 获取字符串
     *
     * @param args
     */
    public static void main(String[] args) {
        String log = "dsds12kj187j87sdfnsd8a/99SD]2/3212\1231";
        //正则表达式
        Pattern pattern = Pattern.compile("\\d{2,}");
        //获得引擎
        Matcher matcher = pattern.matcher(log);

        while (matcher.find()) {
            // System.out.println(matcher.group());
        }

        System.out.println(new GetString().getString("\\d{2,}", log).toString());

    }

    public List<String> getString(String regex, String log) {
        List<String> list = new ArrayList<>();
        Pattern compile = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);//不区分大小写);
        Matcher matcher = compile.matcher(log);
        List<Long> start = new ArrayList<>();
        while (matcher.find()) {
            // list.add(matcher.group());
            // String substring = log.substring(0, matcher.start());
            // log = log.substring(matcher.start());
            // System.out.println(substring);
            // list.add(substring);

        }
        return list;
    }

    public List<String> getString(Pattern compile, String str) {
        List<String> list = new ArrayList<>();
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }

}
