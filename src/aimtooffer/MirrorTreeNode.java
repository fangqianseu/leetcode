package aimtooffer;

import struct.TreeNode;

/**
 * @author qianfang, at 2019-09-09, 20:23
 * <p>
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 **/
public class MirrorTreeNode {
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        mirror(root.left);
        mirror(root.right);
    }
}
