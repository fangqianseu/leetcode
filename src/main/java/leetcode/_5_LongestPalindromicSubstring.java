/*
最长回文子串
Given a string s, return the longest palindromic substring in s
 */
package leetcode;

import java.util.Objects;

public class _5_LongestPalindromicSubstring {

    // 分别以每个字符作为中心 向两边检测是否为回文
    public String longestPalindrome(String s) {
        if (Objects.equals(s, "")) {
            return "";
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 偶数回文场景
            res = checkPalindromePalindrome(s, i, i + 1, res);
            //奇数回文场景
            res = checkPalindromePalindrome(s, i, i, res);
        }
        return res;
    }

    private String checkPalindromePalindrome(String s, int from, int to, String res) {
        // 符合回文特征 from、to向两边扩散
        while (from >= 0 && to < s.length() && s.charAt(from) == s.charAt(to)) {
            from--;
            to++;
        }
        String temp = s.substring(from + 1, to);
        return temp.length() > res.length() ? temp : res;
    }

    //    ===================================================


    public static void main(String[] args) {
        _5_LongestPalindromicSubstring s = new _5_LongestPalindromicSubstring();
        System.out.println(s.longestPalindrome("cbabd"));
    }
}
