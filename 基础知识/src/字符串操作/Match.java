package 字符串操作;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Match {
    /**
     * [abc]  判断一个字符只能是abc中的一个
     * [^abc]  不是abc的一个
     * [a-zA-Z]
     * [a-d[m-p]]  a-z 并 m-p
     * [a-z&&[def]]  交集
     * [a-z&&[^bc]]
     * [a-z&&[]^m-p]
     * <p>
     * .    任何一个字符
     * \d   [0-9]
     * \D   [^0-9]
     * \S   非空白字符
     * \s   空白字符
     * 需要\来转译\
     * <p>
     * X|Y X 或 Y
     * <p>
     * X?+ X，一次或一次也没有
     * X*+ X，零次或多次
     * X++ X，一次或多次
     * X{n}+ X，恰好 n 次
     * X{n,}+ X，至少 n 次
     * X{n,m}+ X，至少 n 次，但是不超过 m 次
     */
    public static void main(String[] args) {
        String regex = "matchQuery"; //个人最常见的匹配多个参数
        String str = "where agentIp = matchQuery('192.168.13.5')";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        if (matcher.matches()) {

        }
        str.contains(regex);

        String type = "3";
        System.out.println(type.matches("3|4"));
        Pattern.matches("3|4", type);

    }

}
