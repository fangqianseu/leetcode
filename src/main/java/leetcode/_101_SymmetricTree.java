/*
Date:04.14,2019 22:52

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
*/
package leetcode;

import struct.TreeNode;

/*
Given the root of a binary tree, check whether it is a mirror of itself
(i.e., symmetric around its center).
 */
public class _101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return false;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        // 都为空场景
        if (null == left && null == right) {
            return true;
        }
        // 其中有一个不为空场景
        if (null == left || null == right) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }


}
