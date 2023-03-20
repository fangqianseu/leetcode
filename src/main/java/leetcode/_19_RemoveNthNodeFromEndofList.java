/*
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
package leetcode;

import struct.ListNode;

public class _19_RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 兼容 n = head.length 的情况
        ListNode res = new ListNode(1);
        res.next = head;

        ListNode fast = res.next;
        ListNode slow = res.next;

        while (n-- > 0) {
            if (null == fast) {
                break;
            }
            fast = fast.next;
        }

        ListNode pre = res;
        while (null != fast) {
            pre = slow;
            fast = fast.next;
            slow = slow.next;
        }
        pre.next = slow.next;
        return res.next;
    }

}
