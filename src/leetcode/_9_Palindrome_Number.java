package leetcode;

/**
 * @author qianfang, at 2021/8/20, 上午12:35
 **/
/*
Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward.
 For example, 121 is palindrome while 123 is not.


 */
public class _9_Palindrome_Number {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _9_Palindrome_Number().isPalindrome(1));
    }
}
