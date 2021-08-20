package 数据结构;

/**
 * @Description:
 * @author: LinQin
 * @date: 2020/06/05
 */
public class SingleLinkedList {
    // 指针位置记录 头 尾巴
    private ListNode pointer_head, pointer_tail;

    public SingleLinkedList(ListNode pointer_head, ListNode pointer_tail) {
        this.pointer_head = pointer_head;
        this.pointer_tail = pointer_tail;
    }

    public SingleLinkedList() {
        pointer_head = pointer_tail = null;
    }

    public SingleLinkedList addNode(int val) {
        if (pointer_head == null) {
            // 链表为空，头指针和尾指针都指向新增节点,形成环
            pointer_head = pointer_tail = new ListNode(val);
        } else {
            // 链表不为空，新增节点连接到表尾，尾指针指向新增节点
            pointer_tail.setNext(new ListNode(val));
            pointer_tail = pointer_tail.getNext();
        }
        return this;
    }

    public ListNode getHead() {
        return pointer_head;
    }

    @Override
    public String toString() {
        String str = "";
        for (ListNode temp = pointer_head; temp != null; temp = temp.getNext()) {
            str +=" " + temp.getVal();
        }
        return str;
    }


    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addNode(5);
        singleLinkedList.addNode(3);
        singleLinkedList.addNode(2);
        singleLinkedList.addNode(4);
        System.out.println(singleLinkedList.toString());
    }
}
