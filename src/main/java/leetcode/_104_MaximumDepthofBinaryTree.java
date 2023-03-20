/*
Date:04.14,2019 23:07
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/
package leetcode;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path
 from the root node down to the farthest leaf node.

 */
public class _104_MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
       if (null == root){
           return 0;
       }
       return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int res = 0;
        while (!stack.isEmpty()) {
            res++;
            List<TreeNode> temp = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                if (null != pop.left) {
                    temp.add(pop.left);
                }
                if (null != pop.right) {
                    temp.add(pop.right);
                }
            }
            stack.addAll(temp);
        }
        return res;
    }
}
