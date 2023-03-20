package leetcode;

import struct.TreeNode;

/**
 * @author qianfang, at 2021/9/23, 上午8:38
 **/
/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ
in height by no more than 1.
 */
public class _110BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        if (null == root.left && null == root.right) {
            return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private Integer getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
