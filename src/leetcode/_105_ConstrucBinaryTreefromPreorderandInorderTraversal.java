/*
Date:04.15,2019 22:32

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
*/
package leetcode;

import struct.TreeNode;

import java.util.Arrays;

public class _105_ConstrucBinaryTreefromPreorderandInorderTraversal {
    /**
     * 利用 前序 中序，构造二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;
        int rootval = preorder[0];
        TreeNode treeNode = new TreeNode(rootval);
        int index = 0;
        while (inorder[index] != rootval)
            index++;
        treeNode.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        treeNode.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return treeNode;
    }

    public static void main(String[] args) {
        new _105_ConstrucBinaryTreefromPreorderandInorderTraversal().buildTree(new int[]{1, 2}, new int[]{1, 2});
    }
}
