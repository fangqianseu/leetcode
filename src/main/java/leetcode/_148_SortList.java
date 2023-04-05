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

        // 注意判断 head.next 不为空  否则mid 和head一致 会无限递归
        if (null == head || head.next == null) {
            return head;
        }

        // 快慢指针 找出中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;

        //从中点截断
        slow.next = null;

        // 递归  将链表分割为单节点
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // 归并排序
        return merge(left, right);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode head = new ListNode();
        ListNode temp = head;
        while (null != l || null != r) {
            if (null != l && null != r) {
                if (l.val <= r.val) {
                    temp.next = l;
                    l = l.next;
                } else {
                    temp.next = r;
                    r = r.next;
                }
            } else if (l != null) {
                temp.next = l;
                l = l.next;
            } else {
                temp.next = r;
                r = r.next;
            }
            temp = temp.next;
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
