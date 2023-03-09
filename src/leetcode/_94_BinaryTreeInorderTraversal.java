/*
Date:04.11,2019 23:22

Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?

*/
package leetcode;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given the root of a binary tree,
return the inorder traversal of its nodes' values.
 */
public class _94_BinaryTreeInorderTraversal {

    /**
     * 二叉树 中序遍历 递归
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        help(res, root);
        return res;
    }

    private void help(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        help(res, root.left);
        res.add(root.val);
        help(res, root.right);
    }

    /**
     * 非递归
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                res.add(pop.val);
                root = pop.right;
            }
        }
        return res;
    }
}
