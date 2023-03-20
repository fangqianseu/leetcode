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

    public ListNode addTwoNumbersBest(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode h = head;

        int add = 0;
        while (l1 != null || l2 != null || add > 0) {
            int temp = add;
            if (null != l1) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (null != l2) {
                temp += l2.val;
                l2 = l2.next;
            }
            h.next = new ListNode(temp % 10);
            h = h.next;
            add = temp / 10;
        }

        return head.next;
    }
}
