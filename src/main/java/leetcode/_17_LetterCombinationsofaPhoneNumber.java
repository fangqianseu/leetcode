/*
手机键盘 的所有可能输出 2-9

Given a string containing digits from 2-9 inclusive,
return all possible letter combinations that the number could represent.
 Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _17_LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinationsBest(String digits) {
        List<String> res = new ArrayList<>();
        // 必须 否则添加初值会出错
        if (Objects.isNull(digits) || digits.equals("")) {
            return res;
        }

        String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        // 给一个初始值 进入循环
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            String s = letters[(int) digits.charAt(i) - '0'];

            List<String> temp = new ArrayList<>();
            for (String origin : res) {
                for (char c : s.toCharArray()) {
                    temp.add(origin + String.valueOf(c));
                }
            }
            res = temp;
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(new _17_LetterCombinationsofaPhoneNumber().letterCombinationsBest("23"));
    }
}
