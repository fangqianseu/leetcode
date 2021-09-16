package leetcode;

import struct.TreeNode;

import java.util.Stack;

/**
 * @author qianfang, at 2021/9/17, 上午12:50
 **/
/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical,
and the nodes have the same value.

 */
public class _100_Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        }
        if (null == p || null == q) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        }
        if (null == p || null == q) {
            return false;
        }

        Stack<TreeNode> s1 = new Stack<>();
        s1.push(p);
        Stack<TreeNode> s2 = new Stack<>();
        s2.push(q);
        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode l = s1.pop();
            TreeNode n = s2.pop();

            if (null == l && null == n) {
                continue;
            }
            if (null == l || null == n) {
                return false;
            }
            if (l.val != n.val) {
                return false;
            }

            s1.push(l.left);
            s2.push(n.left);
            s1.push(l.right);
            s2.push(n.right);
        }
        return s1.size() == s2.size();
    }
}
