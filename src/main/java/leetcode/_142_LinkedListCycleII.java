/*
Date:04.25,2019 22:53
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
*/
package leetcode;

import struct.ListNode;

// 快慢指针 第一次相遇  快指针走了  a + 2b  慢指针走了 a+b
// 设快指针为head  与慢指针一起前进， 相遇时， 必定在入环的第一个节点
public class _142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        boolean isCycle = false;
        while (slow != null && fast != null && fast.next != null) {
            // 先前进 在判断
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) {
            return null;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
