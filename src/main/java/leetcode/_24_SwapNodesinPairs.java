package leetcode;

import struct.ListNode;

/**
 * @author qianfang, at 2022/3/13, 11:46 PM
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 **/
public class _24_SwapNodesinPairs {
    public ListNode swapPairs2(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode p = head.next;
        ListNode v = head.next.next;

        p.next = head;
        head.next = swapPairs2(v);
        return p;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(1);
        res.next = head;

        ListNode p = head;
        ListNode pre = res;
        while (null != p && null != p.next) {
            swap(pre, p);
            // 注意 此时 p已经被交换  后移了一位，位于了应该是 pre 的位置
            pre = p;
            p = p.next;
        }
        return res.next;
    }

    private void swap(ListNode pre, ListNode temp) {
        ListNode next = temp.next;
        ListNode dnext = temp.next.next;

        pre.next = next;
        next.next = temp;
        temp.next = dnext;
    }

    public static void main(String[] args) {
        _24_SwapNodesinPairs swapNodesinPairs = new _24_SwapNodesinPairs();

        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(4);

        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        swapNodesinPairs.swapPairs(t1);
    }
}
