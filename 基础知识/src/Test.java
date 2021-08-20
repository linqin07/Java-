import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @author: LinQin
 * @date: 2019/03/25
 */
public class Test {
    public static void main(String[] args) {
        final String regex = "\\d+\\.\\d+\\.\\d+\\.\\d+";
        final String string = "jdbc:oracle:thin:@10.252.151.153:1521:ultraiam\n"
                + "jdbc:mysql://192.168.13.24:3306/sfasfasfd";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }

}
