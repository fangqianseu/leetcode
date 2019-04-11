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
import java.util.LinkedList;
import java.util.List;

public class _94_BinaryTreeInorderTraversal {

    /**
     * 二叉树 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode temp = root;

        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            res.add(temp.val);
            temp = temp.right;
        }
        return res;
    }
}
