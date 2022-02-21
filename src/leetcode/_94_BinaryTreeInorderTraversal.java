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

    private List<Integer> res = new ArrayList<>();

    /**
     * 二叉树 中序遍历 递归
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (null == root) {
            return res;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }

    /**
     * 非递归
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
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
