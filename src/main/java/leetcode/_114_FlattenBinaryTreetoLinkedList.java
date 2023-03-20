/*
Date:04.15,2019 23:11
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
*/
package leetcode;

import struct.TreeNode;

// 将数组以前序遍历方式生成链表
public class _114_FlattenBinaryTreetoLinkedList {
    /**
     * 将右子树挂在左子树后边
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        flatten(left);
        flatten(right);

        root.right = left;
        TreeNode cur = root;
        while (cur.right != null)
            cur = cur.right;
        cur.right = right;
    }

    /**
     * 具体做法是，对于当前节点，如果其左子节点不为空，则在其左子树中找到最右边的节点，作为前驱节点，
     * 将当前节点的右子节点赋给前驱节点的右子节点，然后将当前节点的左子节点赋给当前节点的右子节点，
     * 并将当前节点的左子节点设为空。
     * 对当前节点处理结束后，继续处理链表中的下一个节点，直到所有节点都处理结束。
     *
     * @param root
     */
    public void flatten2(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode predecessor = curr.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.left = t6;
        t3.right = t7;
        new _114_FlattenBinaryTreetoLinkedList().flatten(t1);
    }
}
