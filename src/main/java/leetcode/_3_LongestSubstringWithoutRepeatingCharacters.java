package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author qianfang, at 2022/3/3, 12:08 AM
 * <p>
 * Given a string s, find the length of the longest substring without repeating characters.
 **/
public class _3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int res = 0;

        // 为开始计算不重复子串的起始位置
        int from = 0;

        // 保持 c 和 index 的映射
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);

            /*
              2种情况：
              1. 之前没有出现过，结束位置就是当前的index
              2，之前出现过 判断之前出现的位置是否大于from：
                 如果小于，则from不变；
                 如果大于from，证明在当前比较的范围有重复字符，from为该字符index的后一位
             */
            if (map.containsKey(c)) {
                from = Math.max(map.get(c) + 1, from);
            }
            map.put(c, i);
            res = Math.max(res, i - from + 1);
        }
        return res;
    }

    /**
     * set里面含有所有的不重复的字符
     * j为范围的尾端，i为范围的首段
     * 当出现重复时，把 set中 从i开始，一直到当前重字符的字符删去
     */
    public int lengthOfLongestSubstring2(String s) {
        int from = 0, to = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (to < s.length()) {
            if (!set.contains(s.charAt(to))) {
                set.add(s.charAt(to++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(from++));
            }
        }

        return max;
    }

    public static void main(String[] args) {
        _3_LongestSubstringWithoutRepeatingCharacters c = new _3_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(c.lengthOfLongestSubstring("abba"));

    }
}
