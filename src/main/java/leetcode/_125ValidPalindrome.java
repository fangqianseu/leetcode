package leetcode;

/**
 * @author qianfang, at 2021/9/27, 上午8:14
 **/
/*
Given a string s, determine if it is a palindrome,
considering only alphanumeric characters and ignoring cases.
 */
public class _125ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            // 可以使用下面的方法简化
            if (Character.isLetterOrDigit(c)) {
                str.append(String.valueOf(c).toLowerCase());
            }
//            if (c >= 'a' && c <= 'z') {
//                str.append(c);
//            } else if (c >= 'A' && c <= 'Z') {
//                str.append(String.valueOf(c).toLowerCase());
//            }else if (c >= '0'&&c <='9'){
//                str.append(c);
//            }
        }
        for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _125ValidPalindrome validPalindrome = new _125ValidPalindrome();
        validPalindrome.isPalindrome("A man, a plan, a canal: Panama");
    }
}
