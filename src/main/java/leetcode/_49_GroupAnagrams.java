/*
Date:04.06,2019 22:23

Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

*/
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _49_GroupAnagrams {

    // 利用 a-z 的位图 保存 单词
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            // 建立 位图
            int[] sign = new int[26];
            Arrays.fill(sign, 0);
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                sign[c - 'a'] = sign[c - 'a'] + 1;
            }

            // 将 位图 转化为 string
            StringBuilder sb = new StringBuilder();
            for (int k : sign) {
                // 这里每一位要添加 | 避免  1 10 和 11 0 区分不出来
                sb.append(k).append("|");
            }

            // 添加入 valueMap
            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new ArrayList<>());
            }
            map.get(sb.toString()).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public List<List<String>> groupAnagramsSort(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            // 将字母排序 作为key 存储
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                sb.append(c);
            }

            // 添加入 valueMap
            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new ArrayList<>());
            }
            map.get(sb.toString()).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }


    public static void main(String[] args) {
        new _49_GroupAnagrams().groupAnagramsSort(new String[]{"bdddddddddd", "bbbbbbbbbbc"});
    }
}
