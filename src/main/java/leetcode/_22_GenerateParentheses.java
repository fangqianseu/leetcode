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
        generateHelp("", n, n, res);
        return res;
    }

    // left 剩余左括号 right 剩余右括号
    private void generateHelp(String s, int left, int right, List<String> res) {
        // 都生成完了 加入结果集
        if (left == 0 && right == 0) {
            res.add(s);
        }
        // 左括号 可以直接生成
        if (left > 0) {
            generateHelp(s + "(", left - 1, right, res);
        }
        //右括号 必须和左括号对应生成
        if (right > 0 && left < right) {
            generateHelp(s + ")", left, right - 1, res);

        }
    }


    public static void main(String[] args) {
        _22_GenerateParentheses generateParentheses = new _22_GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(4));
    }
}
