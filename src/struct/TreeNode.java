package struct;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public String toString() {
        return String.format("[value -> %s, left -> %s, right -> %s]", val, left, right);
    }
}
