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
        ArrayList<String> res = new ArrayList<>();
        // 必须 否则添加初值会出错
        if (Objects.isNull(digits) || digits.equals("")) {
            return res;
        }


        String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        // 给一个初始值 进入循环
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            String s = letters[(int) digits.charAt(i) - '0'];

            ArrayList<String> temp = new ArrayList<>();

            for (String origin : res) {
                for (char c : s.toCharArray()) {
                    temp.add(origin + String.valueOf(c));
                }
            }

            res = temp;
        }

        return res;
    }

    String[] list = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        // 必须 否则添加初值会出错
        if (Objects.isNull(digits) || digits.equals("")) {
            return res;
        }
        // 给一个初始值 进入循环
        res.add("");
        letterCombinationsHelp(digits, 0, res);

        return res;
    }

    private void letterCombinationsHelp(String digits, int index, List<String> res) {
        if (index >= digits.length()) {
            return;
        }
        char c = digits.charAt(index);
        String charList = list[c - '0'];
        if (charList.equals("")) {
            return;
        }
        List<String> newRes = new ArrayList<>();
        for (String re : res) {
            for (char t : charList.toCharArray()) {
                newRes.add(re + String.valueOf(t));
            }
        }
        res.clear();
        res.addAll(newRes);
        letterCombinationsHelp(digits, index + 1, res);
    }

    public static void main(String[] args) {
        new _17_LetterCombinationsofaPhoneNumber().letterCombinations("23");
    }
}
