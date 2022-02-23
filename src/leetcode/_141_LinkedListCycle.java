/*
Date:04.25,2019 22:43
Given a linked list, determine if it has a cycle in it.
*/
package leetcode;

import struct.ListNode;

/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list
that can be reached again by continuously following the next pointer.
Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class _141_LinkedListCycle {

    /*
    快慢指针法
     */
    public boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (null != slow.next && null != fast.next && null != fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
