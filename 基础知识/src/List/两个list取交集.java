package List;

import java.util.ArrayList;
import java.util.List;

public class 两个list取交集 {

    public static void main(String[] args) {
        List<String> A = new ArrayList<>();
        List<String> B = new ArrayList<>();

        A.add("1");
        A.add("2");

        B.add("1");
        B.add("2");
        B.add("3");


//		B.removeAll(A); //去除并集


//		A.addAll(B); //并,会重复。可以去除并集在并。

        A.retainAll(B); //交，共有部分


        for (String list : A) {
            System.out.println(list.toString()); //3
        }
    }

}
