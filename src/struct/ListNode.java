package struct;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
        val = 1;
    }

    public ListNode(int x) {
        val = x;
    }

    public String toString() {
        return String.format("%s --> %s", val, next);
    }
}
