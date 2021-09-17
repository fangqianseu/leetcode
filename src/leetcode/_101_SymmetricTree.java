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
            return true;
        }
        return help(root.left, root.right);
    }

    public boolean help(TreeNode l, TreeNode r) {
        if (null == l && null == r) {
            return true;
        }
        if (null == l || null == r) {
            return false;
        }
        if (r.val != l.val) {
            return false;
        }
        return help(l.left, r.right) && help(l.right, r.left);
    }
}
