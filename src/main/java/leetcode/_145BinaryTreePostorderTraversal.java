package leetcode;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianfang, at 2021/9/28, 上午8:22
 **/
/*
Given the root of a binary tree, return the postorder traversal of its nodes' values.

二叉树后序遍历
 */
public class _145BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        help(root, res);
        return res;
    }

    private void help(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }
        help(root.left, res);
        help(root.right, res);
        res.add(root.val);
    }
}
