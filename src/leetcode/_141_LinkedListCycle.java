/*
Date:04.25,2019 22:43
Given a linked list, determine if it has a cycle in it.
*/
package leetcode;

import struct.ListNode;

public class _141_LinkedListCycle {
    /**
     * 快慢指针法
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // fast 必在 slow 之前 故只用判断 fast 不为空即可
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }
}
