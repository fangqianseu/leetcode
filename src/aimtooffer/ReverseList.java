package aimtooffer;

import struct.ListNode;

/**
 * @author qianfang, at 2019-09-09, 19:40
 * <p>
 * 输入一个链表，反转链表后，输出新链表的表头。
 **/
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode p = null, q = head;

        while (q != null) {
            ListNode temp = q.next;
            q.next = p;

            p = q;
            q = temp;
        }

        return p;
    }
}
