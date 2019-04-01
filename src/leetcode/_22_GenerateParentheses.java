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
    private int n;
    private ArrayList<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        this.n = n;
        generateParenthesisCore(0, 0, "");
        return res;
    }

    private void generateParenthesisCore(int i, int j, String s) {
        if (i == n && j == n) {
            res.add(s);
            return;
        }
        if (i < n) generateParenthesisCore(i + 1, j, s + "(");
        if (i > j) generateParenthesisCore(i, j + 1, s + ")");
    }
}
