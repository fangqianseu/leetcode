package leetcode;

import java.util.Stack;

/**
 * @author qianfang, at 2021/9/28, 上午8:31
 **/
/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
 */
public class _155MinStack {
    class MinStack {
        private Stack<Integer> normalStack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        public MinStack() {

        }

        public void push(int val) {
            normalStack.push(val);
            if (minStack.isEmpty()) {
                minStack.push(val);
            } else {
                minStack.push(Math.min(val, minStack.peek()));
            }
        }

        public void pop() {
            minStack.pop();
            normalStack.pop();
        }

        public int top() {
            return normalStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}

