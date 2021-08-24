package leetcode;

import struct.ListNode;

/*
Merge two sorted linked lists and return it as a sorted list.
The list should be made by splicing together the nodes of the first two lists.
 */
public class _21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(1);
        ListNode head = res;
        while (null != l1 && null != l2) {
            if (l1.val <= l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }

        if (null == l1) {
            res.next = l2;
        }
        if (null == l2) {
            res.next = l1;
        }

        return head.next;
    }

    /*
    递归解法
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode res;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            res = l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            res = l2;
        }

        return res;
    }
}
