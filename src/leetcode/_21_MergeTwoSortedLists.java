package leetcode;

import oj.structs.ListNode;

public class _21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode res;
        if (l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            res = l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            res = l2;
        }

        return res;
    }
}
