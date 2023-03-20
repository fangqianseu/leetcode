package aimtooffer;

import struct.ListNode;

/**
 * @author qianfang, at 2019-09-09, 19:32
 * <p>
 * 输入一个链表，输出该链表中倒数第k个结点。
 **/
public class FindKthToTail {
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }

        ListNode fast = head, slow = head;

        while (k-- > 0) {
            if (fast == null){
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
