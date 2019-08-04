package leetcode;

import struct.TreeNode;

/**
 * by qianfang, at 2019-08-03, 21:17
 * <p>
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 **/
public class _543_DiameterofBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int fromMe = deepth(root.left) + deepth(root.right);
        return Math.max(left, Math.max(right, fromMe));
    }

    private int deepth(TreeNode node) {
        if (null == node)
            return 0;
        return Math.max(deepth(node.left), deepth(node.right)) + 1;
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
