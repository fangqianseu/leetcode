package leetcode;

import struct.ListNode;

/**
 * @author qianfang, at 2021/9/5, 下午11:38
 **/
/*
Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
Return the linked list sorted as well.
 */
public class _83_Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return head;
        }
        ListNode h = head;
        while (null != head.next) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return h;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        _83_Remove_Duplicates_from_Sorted_List remove_duplicates_from_sorted_list = new _83_Remove_Duplicates_from_Sorted_List();
        remove_duplicates_from_sorted_list.deleteDuplicates(l1);
    }
}
