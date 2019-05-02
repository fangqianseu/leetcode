/*
Date:05.02,2019 22:05
Write a program to find the node at which the intersection of two singly linked lists begins.
*/
package leetcode;

import struct.ListNode;

public class _160_IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        ListNode tempA = headA;
        ListNode tempB = headB;
        while (lengthA > lengthB) {
            tempA = tempA.next;
            lengthA--;
        }
        while (lengthB > lengthA) {
            tempB = tempB.next;
            lengthB--;
        }

//      tempA 最后一定为null 且 tempA 和 tempB 长度相等
        while (tempB != tempA) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }

    private int getLength(ListNode head) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
}
