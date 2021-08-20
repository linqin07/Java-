package org.example.bean;

/**
 * @Description:
 * @author: LinQin
 * @date: 2020/11/30
 */
public class String {
    private String string;

    @Override
    public java.lang.String toString() {
        return "String{" +
                "stringccccccccccccc=" + string +
                '}';
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
