/*
Date:05.04,2019 23:25

Reverse a singly linked list.

Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
*/
package leetcode;

import struct.ListNode;

public class _206_ReverseLinkedList {
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
