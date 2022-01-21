import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        final String regex = "application_test_*[\\d]*$";
        // final String string = "application_test_2223\n"
        //         + "application_test_20210923\n"
        //         + "applqqqication_test\n"
        //         + "application_test_111f1_202109091231\n"
        //         + "application_testgggg\n"
        //         + "application_test";

        String allMatch = "application_test";
        String allMatch1 = "application_test_20210923";
        String allMatch2 = "applqqqication_test";
        String allMatch3 = "application_test_111f1_202109091231";

        // final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        // final Matcher matcher = pattern.matcher(allMatch);
        //
        // if (matcher.matches()) {
        //     System.out.println("Full match: " + matcher.group(0));
        //
        // }

        System.out.println(allMatch.matches(regex));
        System.out.println(allMatch1.matches(regex));
        System.out.println(allMatch2.matches(regex));
        System.out.println(allMatch3.matches(regex));

    }
}