package 数据结构;

/**
 * @Description: 长度不一样
 *
 * 例如以下示例中 A 和 B 两个链表相交于 c1：
 *
 * A:          a1 → a2
 *                     ↘
 *                       c1 → c2 → c3
 *                     ↗
 * B:    b1 → b2 → b3
 * 但是不会出现以下相交的情况，因为每个节点只有一个 next 指针，也就只能有一个后继节点，而以下示例中节点 c 有两个后继节点。
 *
 * A:          a1 → a2       d1 → d2
 *                     ↘  ↗
 *                       c
 *                     ↗  ↘
 * B:    b1 → b2 → b3        e1 → e2
 * 要求时间复杂度为 O(N)，空间复杂度为 O(1)。如果不存在交点则返回 null。
 *
 * @author: LinQin
 * @date: 2020/06/05
 */
public class 找两个链表的交点 {
    public static void main(String[] args) {
        SingleLinkedList listNodeA = new SingleLinkedList().addNode(11)
                                                           .addNode(12)
                                                           .addNode(31)
                                                           .addNode(32)
                                                           .addNode(33);
        SingleLinkedList listNodeB = new SingleLinkedList().addNode(21)
                                                           .addNode(22)
                                                           .addNode(23)
                                                           .addNode(31)
                                                           .addNode(32)
                                                           .addNode(33);


        ListNode handle = handle(listNodeA.getHead(), listNodeB.getHead());
        System.out.println();
    }

    public static ListNode handle(ListNode listNodeA, ListNode listNodeB) {
        ListNode l1 = listNodeA;
        ListNode l2 = listNodeB;
        while (l1 != l2) {
            l1 = (l1 == null) ? listNodeB : l1.next;
            l2 = (l2 == null) ? listNodeA : l2.next;
        }
        return l1;
    }
}
