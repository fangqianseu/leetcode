package leetcode;

import struct.TreeNode;

/**
 * by qianfang, at 2019-08-03, 21:17
 * <p>
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * <p>
 * 这种情况  不经过root节点
 * t
 * t  t
 * t t
 * t t
 * t   t
 * t     t
 **/
public class _543_DiameterofBinaryTree {

    // 递归解法   最长的距离 可能不经过root
    public int diameterOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int fromRoot = deepth(root.left) + deepth(root.right);
        return Math.max(left, Math.max(right, fromRoot));
    }

    private int deepth(TreeNode node) {
        if (null == node) {
            return 0;
        }
        return Math.max(deepth(node.right), deepth(node.left)) + 1;
    }

    // ============================================================
    // 便利法  在计算length的时候 就记录最长的距离
    // 把每个节点都当做 root
    int res = 0;

    public int diameterOfBinaryTree2(TreeNode root) {
        if (null == root) {
            return 0;
        }
        deepth2(root);
        return res;
    }

    private int deepth2(TreeNode node) {
        if (null == node) {
            return 0;
        }
        int right = deepth2(node.right);
        int left = deepth2(node.left);
        res = Math.max(res, right + left);
        return Math.max(right, left) + 1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(-4);
        TreeNode node5 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println(new _543_DiameterofBinaryTree().diameterOfBinaryTree(node1));
    }
}
