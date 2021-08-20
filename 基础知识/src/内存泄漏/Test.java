package 内存泄漏;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        //置空，gc下个回合会回收对象，容器占用资源，List仍然有对象的引用，无法回收。
        List list = new ArrayList<>(10);
        for (int i = 0; i < 100; i++) {
            Object object = new Object();
            list.add(object);
            object = null;
        }

    }

}
