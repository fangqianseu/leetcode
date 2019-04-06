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
            for (int j = 0; j < sign.length; j++) {
                sb.append(sign[j]);
            }

            // 添加入 map
            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new ArrayList<>());
            }
            map.get(sb.toString()).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }

    // 拆分单词 排序
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            String key = String.valueOf(chars);
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s);
        }

        return new ArrayList<List<String>>(map.values());
    }


    public static void main(String[] args) {
        new _49_GroupAnagrams().groupAnagrams(new String[]{"aazz", "zzaa"});
    }
}
