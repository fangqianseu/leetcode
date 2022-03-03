/*
最长回文子串
Given a string s, return the longest palindromic substring in s
 */
package leetcode;

public class _5_LongestPalindromicSubstring {

    // 分别以每个字符作为中心 向两边检测是否为回文
    public String longestPalindrome2(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 偶数回文
            res = checkPalindromePalindrome(s, i, i + 1, res);
            // 奇数回文
            res = checkPalindromePalindrome(s, i, i, res);
        }
        return res;

    }

    private String checkPalindromePalindrome(String s, int from, int to, String res) {
        while (from >= 0 && to < s.length() && s.charAt(from) == s.charAt(to)) {
            from--;
            to++;
        }
        String temp = s.substring(from + 1, to);
        return temp.length() > res.length() ? temp : res;
    }

    //    ===================================================
    // 暴力法 超时 O(n^2)
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (isPalindrome(temp)) {
                    res = res.length() > temp.length() ? res : temp;
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        _5_LongestPalindromicSubstring s = new _5_LongestPalindromicSubstring();
        System.out.println(s.longestPalindrome2("cbbd"));
    }
}
