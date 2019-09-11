package aimtooffer;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author qianfang, at 2019-09-10, 10:29
 * <p>
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 **/
public class PrintTreeNodeFromTop {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.pollFirst();
                res.add(node.val);
                if (null != node.left) {
                    queue.addLast(node.left);
                }
                if (null != node.right) {
                    queue.addLast(node.right);
                }
            }
        }

        return res;
    }
}
