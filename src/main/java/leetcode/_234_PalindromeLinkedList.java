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
    public boolean isPalindrome2(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (null != head) {
            sb.append(head.val);
            head = head.next;
        }
        for (int i = 0, j = sb.length() - 1; i <= j; i++, j--) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        //  无论个数为奇偶数   mid 为中间前一个
        ListNode mid = head, fast = head;
        while (fast != null && fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }

        mid = reserve(mid);
        fast = head;

        while (mid != null && fast != null) {
            if (mid.val != fast.val)
                return false;
            mid = mid.next;
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
