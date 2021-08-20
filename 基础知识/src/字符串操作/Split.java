package 字符串操作;

import java.util.Arrays;

public class Split {
    /**
     * 切割
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "https://ke.qq.com/webcourse/index.html#course_id=281000&term_id=100332783&taid=1996017331620264&vid=k1424wxjpg7";
        String[] split = str.split("&");
        for (String s : split) {
            System.out.println(s.toString());
        }

        String str1 = "untm.username.termid";
        String[] split1 = str1.split(".");  //错误的，点号需要转译\\.
        for (String s : split1) {
            System.out.println(s.toString());
        }


    }

}
