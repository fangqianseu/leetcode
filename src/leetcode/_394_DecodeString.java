/*
Date: 05/31,2019, 08:08

Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits
and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/
package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class _394_DecodeString {
    /**
     * 利用 stack，入栈时处理 数字
     * 遇到 ]，处理重复字符串，重新写入stack中
     * @param s
     * @return
     */
    public String decodeString(String s) {
        LinkedList<String> list = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else if (c == '[') {
                list.push(String.valueOf(count));
                list.push(String.valueOf("["));
                count = 0;
            } else if (Character.isLetter(c)) {
                list.push(String.valueOf(c));
            } else {
                ArrayList<String> temp = new ArrayList<>();
                while (!list.isEmpty() && !list.peek().equals("["))
                    temp.add(list.poll());
                list.pop();

                int n = Integer.parseInt(list.pop());
                for (int j = 0; j < n; j++) {
                    for (int t = temp.size() - 1; t >= 0; t--)
                        list.push(temp.get(t));
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--)
            stringBuilder.append(list.get(i));

        return stringBuilder.toString();
    }
}
