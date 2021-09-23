package leetcode;

import struct.TreeNode;

/**
 * @author qianfang, at 2021/9/23, 上午8:13
 **/

/*
Given an integer array nums where the elements are sorted in ascending order,
convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees
of every node never differs by more than one.
 */
public class _108_ConvertSortedArraytoBinarySearchTree {

    /*
    也可以将 nums 传递下来 不用每次都生成新数组
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int mid = nums.length / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);

        int[] left = new int[mid];
        System.arraycopy(nums, 0, left, 0, left.length);
        treeNode.left = sortedArrayToBST(left);

        int[] right = new int[nums.length - mid - 1];
        System.arraycopy(nums, mid + 1, right, 0, right.length);
        treeNode.right = sortedArrayToBST(right);
        return treeNode;
    }

    public static void main(String[] args) {
        _108_ConvertSortedArraytoBinarySearchTree convertSortedArraytoBinarySearchTree = new _108_ConvertSortedArraytoBinarySearchTree();
        convertSortedArraytoBinarySearchTree.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
