package aimtooffer;

import struct.ListNode;

import java.util.ArrayList;

/**
 * by qianfang, at 2019-08-23, 00:30
 **/
public class PrintListFromTailToHead {
    public ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (null == listNode) {
            return null;
        }
        printListFromTailToHead(listNode.next);
        res.add(listNode.val);
        return res;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        System.out.println(new PrintListFromTailToHead().printListFromTailToHead(n1));
    }
}
