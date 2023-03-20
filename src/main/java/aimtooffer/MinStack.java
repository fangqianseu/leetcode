package aimtooffer;

import java.util.Stack;

/**
 * @author qianfang, at 2019-09-10, 09:32
 **/
public class MinStack {
    private Stack<Integer> s = new Stack<>();
    private Stack<Integer> smin = new Stack<>();

    public void push(int node) {
        s.push(node);
        if (smin.isEmpty()) {
            smin.push(node);
        } else {
            smin.push(Math.min(smin.peek(), node));
        }
    }

    public void pop() {
        s.pop();
        smin.pop();
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return smin.peek();
    }
}
