/*
最长回文子串
 */
package leetcode;

public class _5_LongestPalindromicSubstring {
    String res = "";

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        for (int i = 0; i < s.length(); i++) {
            mycore(s, i, i);
            mycore(s, i, i + 1);
        }
        return res;
    }

    private void mycore(String s, int l, int r) {
        while (l <= r && l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        if (res.length() < (--r - ++l + 1))
            res = s.substring(l, r + 1);
    }
}
