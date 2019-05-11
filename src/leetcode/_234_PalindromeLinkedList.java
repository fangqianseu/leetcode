/*
Date:05.10,2019 23:13
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true

Follow up:
Could you do it in O(n) time and O(1) space?
*/
package leetcode;

import struct.ListNode;

public class _234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reserve(slow);
        fast = head;

        while (slow != null && fast != null){
            if (slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reserve(ListNode head) {
        ListNode p = null, q = head;
        while (q != null) {
            ListNode t = q.next;

            q.next = p;

            p = q;
            q = t;
        }
        return p;
    }
}
