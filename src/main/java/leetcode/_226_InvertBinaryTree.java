/*
Date:05.10,2019 23:08
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
*/
package leetcode;

import struct.TreeNode;

public class _226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        TreeNode invertR = invertTree(root.right);
        TreeNode invertL = invertTree(root.left);
        root.right = invertL;
        root.left = invertR;
        return root;
    }
}
