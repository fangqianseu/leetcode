package leetcode;

/**
 * @author qianfang, at 2021/9/1, 上午12:42
 **/

/*
Given a string s consisting of some words separated by some number of spaces,
return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.
 */
public class _58_Length_of_Last_Word {

    public int lengthOfLastWordBest(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                res++;

                // 是空格 且 res 有值 则一定是空 末单词前的空格
            } else if (res > 0) {
                return res;
            }
        }
        return res;
    }

    public int lengthOfLastWord(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int res = 0;
        boolean hasTest = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                hasTest = true;
            }
            if (c == ' ' && hasTest) {
                break;
            }
            if (c != ' ') {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _58_Length_of_Last_Word length_of_last_word = new _58_Length_of_Last_Word();
        System.out.println(length_of_last_word.lengthOfLastWord(" a4ld  "));
    }
}
