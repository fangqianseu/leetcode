package aimtooffer;

import struct.TreeNode;

import java.util.Arrays;

/**
 * by qianfang, at 2019-09-02, 19:49
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 **/
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        int rootVal = pre[0];

        // 中序便利 根节点的index
        int index = 0;
        while (in[index] != rootVal) {
            index++;
        }

        TreeNode treeNode = new TreeNode(rootVal);
        treeNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, index + 1), Arrays.copyOfRange(in, 0, index));
        treeNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre, index + 1, pre.length), Arrays.copyOfRange(in, index + 1, in.length));
        return treeNode;
    }
}
