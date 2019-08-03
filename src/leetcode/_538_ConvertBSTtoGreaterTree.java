package leetcode;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * by qianfang, at 2019-08-03, 16:35
 * <p>
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST
 * is changed to the original key plus sum of all keys greater than the original key in BST.
 **/
public class _538_ConvertBSTtoGreaterTree {
    /**
     * 方法一：
     * 一次遍历，获取所有val列表
     * 再一次便利，找出比自己大的val的sum
     */
    List<Integer> list = new ArrayList<>();

    public TreeNode convertBST2(TreeNode root) {
        if (root == null)
            return null;
        if (list.isEmpty()) {
            travel(root);
            Collections.sort(list);
        }
        root.val += list.stream().filter(i -> i > root.val).mapToInt(i -> i).sum();
        convertBST(root.left);
        convertBST(root.right);
        return root;
    }

    private void travel(TreeNode root) {
        if (root == null)
            return;
        list.add(root.val);
        travel(root.left);
        travel(root.right);
    }

    /**
     * 方法二 递归
     * 注意 已经是二叉树，left < root < right !!!!
     */

    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    public int dfs(TreeNode root, int val) {
        if (root == null)
            return val;
        int right = dfs(root.right, val);
        root.val = root.val + right;
        int left = dfs(root.left, root.val);

        // 返回 left 是因为 left 为这一块的和
        return left;
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

        System.out.println(new _538_ConvertBSTtoGreaterTree().convertBST(node1));
    }
}
