/*
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
package leetcode;

import oj.structs.ListNode;

public class _19_RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(-1);
        res.next = head;

        ListNode temp = res.next;
        while (n-- > 0 ) {
            if (temp == null) return head;
            temp = temp.next;
        }

        ListNode now = res;
        while (temp != null){
            temp = temp.next;
            now = now.next;
        }

        now.next = now.next.next;
        return res.next;
    }
}
