package leetcode;

import struct.TreeNode;

/**
 * @author qianfang, at 2021/9/23, 上午8:50
 **/
/*
Given the root of a binary tree and an integer targetSum,
return true if the tree has a root-to-leaf path such that adding up all the values
along the path equals targetSum.

A leaf is a node with no children.
 */
public class _112PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        targetSum -= root.val;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
