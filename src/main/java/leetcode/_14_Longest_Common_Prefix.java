package leetcode;

/**
 * @author qianfang, at 2021/8/22, 下午11:29
 **/

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.
 */
/*
    最大公共前缀 则对所有的元素都成立
    一个一个比较即可 对每2个元素 求最长前缀
 */
public class _14_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            /*
            原始版本
            int j = 0;
            for (; j < s.length() && j < prefix.length(); j++) {
                if (s.charAt(j) != prefix.charAt(j)) {
                    break;
                }
            }
            prefix = prefix.substring(0, j);
             */
            while (!s.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        _14_Longest_Common_Prefix longest_common_prefix = new _14_Longest_Common_Prefix();
        System.out.println(longest_common_prefix.longestCommonPrefix(new String[]{"flower", "flow"}));
    }
}
