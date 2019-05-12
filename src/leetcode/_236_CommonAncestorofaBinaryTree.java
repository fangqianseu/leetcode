/*
Date:05.12,2019 22:23

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
as the lowest node in T that has both p and q as descendants
(where we allow a node to be a descendant of itself).”
*/
package leetcode;

import struct.TreeNode;

import java.util.*;

public class _236_CommonAncestorofaBinaryTree {
    /**
     * 通过一个 hashmap 记录 <node,parent>
     * 针对 p，用 set 记录 p 到 root 的节点路径
     * 对q 每次求 parent，都在set中查询
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) return null;

        LinkedList<TreeNode> stack = new LinkedList<>();
        Map<TreeNode, TreeNode> parentmap = new HashMap<>();
        stack.push(root);

        while (!parentmap.containsKey(p) || !parentmap.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
                parentmap.put(node.left, node);
            }
            if (node.right != null) {
                stack.push(node.right);
                parentmap.put(node.right, node);
            }
        }

        Set<TreeNode> parentset = new HashSet<>();
        while (p != null) {
            parentset.add(p);
            p = parentmap.get(p);
        }

        while (!parentset.contains(q)) {
            q = parentmap.get(q);
        }

        return q;
    }

    /**
     * 最优解法
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
