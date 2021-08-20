package 字符串操作;

import com.sun.istack.internal.logging.Logger;

import javax.swing.*;
import java.util.Objects;

/**
 * @Description:
 * @author: LinQin
 * @date: 2019/08/14
 */
public class PasswdHandle {
    public static void main(String[] args) {
        String pwd = "123456";
        // 使用 java 推荐的方式
        JPasswordField jPasswordField = new JPasswordField(pwd);
        char[] password1 = jPasswordField.getPassword();
        System.out.println(password1);

        // 普通方式
        char[] chars = pwd.toCharArray();
        System.out.println(chars);

        System.out.println("Array:" + chars);


    }
}
