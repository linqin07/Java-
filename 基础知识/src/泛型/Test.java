package 泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: T代表一个类型，？代表不确定类型 <T> 表示固定的一个内部类型，不用转型。
 * @author: LinQin
 * @date: 2018/11/22
 */
public class Test {
    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();

        name.add("icon");
        age.add(18);
        number.add(314);

        getData(name);
        getData(age);
        getData(number);


        //
        String[] inputArray = {"1", "2"};
        printArray(inputArray);

    }

    public static void getData(List<?> data) {
        System.out.println("data :" + data.get(0));
    }

    // 泛型方法 printArray
    public static <T> void printArray(T[] inputArray) {
        // 输出数组元素
        for (T element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
        return;
    }
}
