/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 determine if the input string is valid.
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

 */
public class _20_ValidParentheses {

    public boolean isValidBest(String s) {
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('(', ')');
        charMap.put('[', ']');
        charMap.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty() || charMap.get(stack.peek()) != c) {
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        _20_ValidParentheses validParentheses = new _20_ValidParentheses();
        System.out.println(validParentheses.isValidBest("()[]{[]()}"));
        System.out.println(validParentheses.isValidBest("]"));
        System.out.println(validParentheses.isValidBest("["));
    }
}
