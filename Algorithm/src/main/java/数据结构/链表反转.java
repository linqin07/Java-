package 数据结构;

/**
 * @Description:
 * @author: LinQin
 * @date: 2020/06/11
 */
public class 链表反转 {
    public static void main(String[] args) {

    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode listNode = reverseList(next);
        next.next = head;
        head.next = null;
        return listNode;
    }
}
