package 数据结构;

import lombok.Data;

import java.util.Objects;

/**
 * @Description:
 * @author: LinQin
 * @date: 2020/06/05
 */
@Data
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

}
