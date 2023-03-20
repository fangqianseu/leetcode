package leetcode;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author qianfang, at 2021/9/27, 上午8:36
 **/
/*
Given the root of a binary tree, return the preorder traversal of its nodes' values.
 */
public class _144BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        help(root, res);
        return res;
    }

    /*
    模拟递归的栈解法
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (null == pop) {
                continue;
            }
            res.add(pop.val);
            if (null != pop.right) {
                stack.push(pop.right);
            }
            if (null != pop.left) {
                stack.push(pop.left);
            }
        }
        return res;
    }

    private void help(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }
        res.add(root.val);
        help(root.left, res);
        help(root.right, res);
    }
}
