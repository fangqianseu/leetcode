/*
Date:04.30,2019 22:58

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/
package leetcode;

import java.util.LinkedList;

class MinStack {
    private LinkedList<Integer> stack;
    private LinkedList<Integer> minstack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new LinkedList<>();
        minstack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minstack.isEmpty())
            minstack.push(x);
        else {
            minstack.push(Math.min(minstack.peek(), x));
        }
    }

    public void pop() {
        minstack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}
