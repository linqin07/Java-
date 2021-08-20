package guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @author: LinQin
 * @date: 2020/09/09
 */
public class TableTest {
    public static void main(String[] args) {
        Table<String, String, Integer> tables = HashBasedTable.create();
        tables.put("a", "javase", 80);
        tables.put("a", "javaee", 90);
        tables.put("c", "javame", 100);
        tables.put("d", "guava", 70);



        Set<Table.Cell<String, String, Integer>> cells = tables.cellSet();
        for (Table.Cell<String, String, Integer> temp : cells) {
            System.out.println(temp.getRowKey() + " " + temp.getColumnKey() + " " + temp.getValue());
        }
        System.out.println(tables.toString());
        // 输出结果：
        // d guava 70
        // b javaee 90
        // c javame 100
        // a javase 80

        Set<String> students = tables.rowKeySet();
        for (String str : students) {
            System.out.print(str + "\t");
        }
        // 输出结果：
        // d   b   c   a

        Set<String> courses = tables.columnKeySet();
        for (String str : courses) {
            System.out.print(str + "\t");
        }
        // 输出结果：
        // guava   javaee  javame  javase

        Collection<Integer> scores = tables.values();
        for (Integer in : scores) {
            System.out.print(in + "\t");
        }
        // 输出结果：
        // 70  90  100 80

        System.out.println();
        System.out.println(tables.row("a").values());
        System.out.println(tables.row("a"));

        System.out.println("------------------");
        Table<Long, Long, String> t = HashBasedTable.create();
        t.put(1L, 1L, "规则1");
        t.put(1L, 2L, "规则2");
        t.put(1L, 3L, "规则3");
        t.put(2L, 1L, "规则1");
        t.put(2L, 2L, "规则2");
        t.put(2L, 3L, "规则3");
        t.put(3L, 2L, "规则1");
        t.put(3L, 2L, "规则2");
        t.put(4L, 2L, "规则2");
        t.put(4L, 6L, "规则3");
        t.clear();

        Table<Long, Long, String> dd = Tables.synchronizedTable(t);
        System.out.println(t.get(3L, 4L));
        Map<Long, String> row = t.row(4L);
        System.out.println(row);

        System.out.println(System.currentTimeMillis());

    }
}
