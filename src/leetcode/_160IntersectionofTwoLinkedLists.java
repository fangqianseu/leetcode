package leetcode;

import struct.ListNode;

/**
 * @author qianfang, at 2021/9/28, 上午8:40
 **/
/*
Given the heads of two singly linked-lists headA and headB,
return the node at which the two lists intersect.
If the two linked lists have no intersection at all, return null.

 */
public class _160IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        int between = Math.abs(lengthA - lengthB);

        if (lengthB >= lengthA) {
            headB = goHead(headB, between);
        } else {
            headA = goHead(headA, between);
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

    private ListNode goHead(ListNode node, int between) {
        while (between > 0) {
            node = node.next;
            between--;
        }
        return node;
    }

    private int getLength(ListNode headA) {
        ListNode head = headA;
        int res = 0;
        while (null != head) {
            res++;
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);

        l1.next = l2;
        l2.next = l3;
        l3.next = l6;
        l6.next = l7;

        l4.next = l5;
        l5.next = l6;

        _160IntersectionofTwoLinkedLists intersectionofTwoLinkedLists = new _160IntersectionofTwoLinkedLists();
        intersectionofTwoLinkedLists.getIntersectionNode(l1, l4);
    }
}
