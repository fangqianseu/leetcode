package aimtooffer;

import struct.ListNode;

/**
 * @author qianfang, at 2019-09-09, 19:44
 * <p>
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 **/
public class MergeListNode {
    /**
     * 递归解法
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode res = null;
        if (list1.val <= list2.val) {
            res = list1;
            res.next = Merge(list1.next, list2);
        } else {
            res = list2;
            res.next = Merge(list1, list2.next);
        }

        return res;
    }

    /**
     * 非递归
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge2(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(), temp = res;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    temp.next = list1;
                    list1 = list1.next;
                } else {
                    temp.next = list2;
                    list2 = list2.next;
                }
                temp = temp.next;
            } else if (list1 == null) {
                temp.next = list2;
                break;
            } else {
                temp.next = list1;
                break;
            }
        }
        return res.next;
    }

}
