/*
Date:04.13,2019 23:36

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

*/
package leetcode;

import struct.TreeNode;

import java.util.Stack;

public class _98_ValidateBinarySearchTree {
    /**
     * 递归 建立 判断辅助函数(node,max,min), node 的 val 必须在 min 和 max 之间
     * 在对 node 的 left 和 right 递归判断，更新 min 和 max 的值
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBSTCore(root, null, null);
    }

    private boolean isValidBSTCore(TreeNode node, Integer min, Integer max) {
        if (node == null)
            return true;
        if ((max != null && node.val >= max) || (min != null && node.val <= min))
            return false;
        return isValidBSTCore(node.left, min, node.val) && isValidBSTCore(node.right, node.val, max);
    }

    /**
     * 非递归， 中序遍历
     * 保留pre 节点，判断 val 是否递增
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode p = stack.pop();
                if (pre != null && p.val <= pre.val) {
                    return false;
                }
                pre = p;
                cur = p.right;
            }
        }
        return true;
    }

}
