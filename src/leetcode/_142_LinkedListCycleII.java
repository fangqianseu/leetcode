/*
Date:04.25,2019 22:53
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
*/
package leetcode;

import struct.ListNode;

public class _142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        boolean isCycle = false;
        while (!isCycle && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                isCycle = true;
            }
        }

        if (!isCycle) return null;

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
