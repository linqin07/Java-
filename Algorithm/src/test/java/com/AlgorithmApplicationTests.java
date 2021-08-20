package com;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class AlgorithmApplicationTests {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(1000);

        String str = "\n";
        if (str.length() == 0 || (str.length() >= 1 && "\n".equals(str.substring(str.length() - 1, str.length())))) {
        } else {
            System.out.println("ha\nha");

        }

        System.out.println("----------");
        String dot = "[";
        String str1 = "asdf.[sdf";
        String[] split = str1.split(dot.replace(".","\\.").replace("[", "\\[")
                                       .replace("]", "\\]").replace("|", "\\|")
                                        .replace("+", "\\+").replace("*", "\\*"));
        System.out.println(Arrays.toString(split));
    }
}
