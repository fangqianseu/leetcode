package aimtooffer;

import struct.TreeNode;

import java.util.ArrayList;

/**
 * @author qianfang, at 2019-09-12, 09:13
 * <p>
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径
 **/
public class FindPath {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(root, target, list);
        return res;
    }

    private void helper(TreeNode root, int target, ArrayList<Integer> list) {
        if (root == null || target < root.val) {
            return;
        }

        list.add(root.val);
        if (target == root.val && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        }
        if (target > root.val) {
            helper(root.left, target - root.val, list);
            helper(root.right, target - root.val, list);
        }
        list.remove(list.size() - 1);

    }

    public static void main(String[] args) {
        FindPath findPath = new FindPath();
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(12);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        System.out.println(findPath.FindPath(n1, 15));
    }
}
