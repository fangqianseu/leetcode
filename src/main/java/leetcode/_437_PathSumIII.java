package leetcode;

import struct.TreeNode;

/**
 * author: fangqian
 * date: 2019-07-27, 17:16
 * <p>
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * <p>
 * The path does not need to start or end at the root or a leaf, but it must go downwards
 * (traveling only from parent nodes to child nodes).
 */

public class _437_PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int pathImLeading = pathSumFromNode(root, sum); // 自己为开头的路径数
        int leftPathSum = pathSum(root.left, sum); // 左边路径总数
        int rightPathSum = pathSum(root.right, sum); // 右边路径总数
        return leftPathSum + rightPathSum + pathImLeading;
    }

    // 从 node 出发的个数
    public int pathSumFromNode(TreeNode node, int sum) {
        if (node == null) return 0;
        int fromMe = (node.val == sum) ? 1 : 0;
        int leftBrother = pathSumFromNode(node.left, sum - node.val);
        int rightBrother = pathSumFromNode(node.right, sum - node.val);
        return fromMe + leftBrother + rightBrother;
    }
}
