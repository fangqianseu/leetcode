/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 determine if the input string is valid.
 */
package leetcode;

import java.util.Stack;

public class _20_ValidParentheses {
    private Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        new _20_ValidParentheses().isValid("{[]}");
    }

    /*
    Leetcode 上 最好的一个解法
     */
    public boolean isValidBest(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (march(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    private boolean march(char c) {
        if (stack.isEmpty()) return false;
        if (c == ')' && stack.peek() == '(') return true;
        else if (c == ']' && stack.peek() == '[') return true;
        else if (c == '}' && stack.peek() == '{') return true;
        else return false;
    }
}
