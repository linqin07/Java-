package 集合Set;

import java.util.*;

/**
 * Description:
 * author: LinQin
 * date: 2018/08/20
 */
public class Test {
    public static void main(String[] args) {
        /*可以添加null，没有自然顺序*/
        HashSet set = new HashSet();
        set.add(3);
        set.add(4);
        set.add(1);
        set.add(null);
        set.forEach(System.out::println);
        System.out.println();

        /*不能添加null，有自然顺序 */
        TreeSet treeSet = new TreeSet();
        treeSet.add("3");
        treeSet.add("3");
        treeSet.add("4");
        treeSet.add("1");
        // treeSet.add(null);
        treeSet.forEach(System.out::println);
        System.out.println();

        /*保证添加顺序*/
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("3");
        linkedHashSet.add("3");
        linkedHashSet.add("4");
        linkedHashSet.add("1");
        linkedHashSet.forEach(System.out::println);

        System.out.println("----------------------");

        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        linkedList.offer(5);
        System.out.println(linkedList.poll());
        System.out.println(linkedList.element());
        System.out.println(linkedList.pop());

        System.out.println(linkedList.toString());
    }
}
