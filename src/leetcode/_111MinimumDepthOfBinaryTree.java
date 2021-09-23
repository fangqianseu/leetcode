package leetcode;

import struct.TreeNode;

/**
 * @author qianfang, at 2021/9/23, 上午8:44
 **/
/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node
 down to the nearest leaf node.

Note: A leaf is a node with no children.
 */
public class _111MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        // 如果出现深度为0的 则不为叶子节点 则需要用另一个子树高度
        if (left == 0 || right == 0) {
            return Math.max(left, right) + 1;
        }

        return Math.min(left, right) + 1;
    }
}
