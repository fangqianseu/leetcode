/*
Date:04.28,2019 23:09

Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
*/
package leetcode;

import struct.ListNode;

public class _148_SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = head, fast = head;
        ListNode pre = null;

        // 找到listnode 的中点
        while (fast != null && fast.next != null) {
            pre = mid;
            mid = mid.next;
            fast = fast.next.next;
        }

        // 从 中点前截断
        pre.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(mid);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (left != null || right != null) {
            if (left != null && right != null) {
                if (left.val <= right.val) {
                    temp.next = left;
                    temp = temp.next;
                    left = left.next;
                } else {
                    temp.next = right;
                    temp = temp.next;
                    right = right.next;
                }
            } else if (left == null) {
                temp.next = right;
                temp = temp.next;
                right = right.next;
            } else {
                temp.next = left;
                temp = temp.next;
                left = left.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        new _148_SortList().sortList(l1);
    }
}
