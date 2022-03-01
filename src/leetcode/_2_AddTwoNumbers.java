package leetcode;

import struct.ListNode;

/**
 * @author qianfang, at 2022/3/2, 12:29 AM
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 **/
public class _2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode h = head;

        int add = 0;
        while (l1 != null || l2 != null) {
            int temp = 0;
            if (l1 != null && l2 != null) {
                temp = l1.val + l2.val + add;
                l1 = l1.next;
                l2 = l2.next;
            } else {
                ListNode t = l1 == null ? l2 : l1;
                temp = t.val + add;

                if (null == l2) {
                    l1 = l1.next;
                } else {
                    l2 = l2.next;
                }
            }

            add = temp >= 10 ? 1 : 0;
            h.next = new ListNode(temp % 10);
            h = h.next;
        }

        if (add > 0) {
            h.next = new ListNode(1);
        }

        return head.next;
    }
}
