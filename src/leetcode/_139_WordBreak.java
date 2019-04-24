/*
Date:04.20,2019 10:30
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
*/
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _139_WordBreak {
    /**
     * dp[i] 为 第i之前的 字符串 能否被字典切割
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        // 匹配 从 0 开始的字符串
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a"));
        new _139_WordBreak().wordBreak("b", list);
    }
}
