package leetcode;
/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */

import java.util.ArrayList;
import java.util.List;

public class _22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, 0, 0, n, "");
        return res;
    }

    // l :（ 已经生成个数
    // r： ) 已经生成个数
    private void helper(List<String> res, int l, int r, int n, String s) {
        if (l == n && r == n) {
            res.add(s);
            return;
        }
        if (l < n) {
            helper(res, l + 1, r, n, s + "(");
        }
        // 注意 一定是要 r 小于 l 而不是 n； 不然 () 不会闭合
        if (r < l) {
            helper(res, l, r + 1, n, s + ")");
        }
    }

    public static void main(String[] args) {
        _22_GenerateParentheses generateParentheses = new _22_GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(4));
    }
}
