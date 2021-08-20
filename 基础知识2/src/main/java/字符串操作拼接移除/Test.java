package 字符串操作拼接移除;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: LinQin
 * @date: 2018/10/24
 */
public class Test {
    public static void main(String[] args) {
        String str = "table1,table2,";
        System.out.println(str.substring(0, str.length() - 1));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        StringBuilder deleteCharAt = stringBuilder.deleteCharAt(str.length() - 1);

        System.out.println(deleteCharAt.toString());

        //拼接逗号
        List<String> list = new ArrayList<>();
        list.add("table1");
        list.add("table2");
        list.add("table3");
        list.add("table4");

        //使用谷歌的Guava，智能拼接，不用删除最后的多余符号
        String joinStr = Joiner.on(",").join(list);
        System.out.println(joinStr);
    }
}
