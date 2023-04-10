/*
Date:05.02,2019 22:05
Write a program to find the node at which the intersection of two singly linked lists begins.
*/
package leetcode;

import struct.ListNode;

public class _160_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lA = getLength(headA);
        int lB = getLength(headB);
        int diff = Math.abs(lA - lB);

        if (lA > lB) {
            headA = goHead(headA, diff);
        } else {
            headB = goHead(headB, diff);
        }

        while (null != headA && null != headB) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    /**
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeBest(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }

    private ListNode goHead(ListNode node, int between) {
        while (between > 0) {
            node = node.next;
            between--;
        }
        return node;
    }

    private int getLength(ListNode head) {
        ListNode l = head;
        int length = 0;
        while (null != l) {
            length++;
            l = l.next;
        }
        return length;
    }
}
