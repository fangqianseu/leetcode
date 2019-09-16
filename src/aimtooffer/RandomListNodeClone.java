package aimtooffer;

import struct.RandomListNode;

/**
 * @author qianfang, at 2019-09-12, 09:45
 * <p>
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 **/
public class RandomListNodeClone {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        // 复制，确定next
        RandomListNode p = pHead;
        while (p != null) {
            RandomListNode node = new RandomListNode(p.label);
            node.next = p.next;
            p.next = node;

            p = node.next;
        }

        // 确定 random
        p = pHead;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        // 分割
        p = pHead;
        RandomListNode res = p.next, q = res;
        while (q != null) {
            p.next = q.next;
            p = p.next;

            q.next = p == null ? null : p.next;
            q = q.next;
        }

        return res;
    }

    public static void main(String[] args) {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);

        n1.next = n2;
        n2.next = n3;
        n1.random = n3;

        RandomListNodeClone randomListNodeClone = new RandomListNodeClone();
        randomListNodeClone.Clone(n1);
    }
}
