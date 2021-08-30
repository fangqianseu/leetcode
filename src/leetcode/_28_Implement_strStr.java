package leetcode;

/**
 * @author qianfang, at 2021/8/30, 上午12:58
 **/
/*
Implement strStr().

Return the index of the first occurrence of needle in haystack,
or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string?
This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string.
 This is consistent to C's strstr() and Java's indexOf().
 */
public class _28_Implement_strStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 0)
            return -1;


        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.substring(i).startsWith(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _28_Implement_strStr implement_strStr = new _28_Implement_strStr();
        System.out.println(implement_strStr.strStr("adaiqwe", "ai"));
    }
}
