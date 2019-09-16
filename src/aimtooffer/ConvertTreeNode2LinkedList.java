package aimtooffer;

import struct.TreeNode;

/**
 * @author qianfang, at 2019-09-12, 10:33
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 **/
public class ConvertTreeNode2LinkedList {
    private TreeNode head;
    private TreeNode pre;

    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        convert(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            pre = head;
        } else {
            pre.right = pRootOfTree;
            pRootOfTree.left = pre;
            pre = pRootOfTree;
        }
        convert(pRootOfTree.right);

        return head;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;
        n3.right = n4;

        ConvertTreeNode2LinkedList convertTreeNode2LinkedList = new ConvertTreeNode2LinkedList();
        convertTreeNode2LinkedList.convert(n1);
    }
}
