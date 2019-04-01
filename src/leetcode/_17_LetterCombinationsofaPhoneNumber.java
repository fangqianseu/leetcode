/*
手机键盘 的所有可能输出 2-9
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _17_LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
            ArrayList<String> res = new ArrayList<>();
            if (digits == null || digits.length() == 0) return res;
            String[] letters = new String[]{
                    "", "", "abc", "def", "ghi", "jkl", "mno",
                    "pqrs", "tuv", "wxyz"};

            res.add("");
            for (int i = 0; i < digits.length(); i++) {
                String s = letters[(int) digits.charAt(i) - '0'];

                ArrayList<String> temp = new ArrayList<>();
                for (int j = 0; j < res.size(); j++) {
                    String base = res.get(j);
                    for (int k = 0; k < s.length(); k++) {
                        temp.add(base + s.charAt(k));
                    }
                }

                res = temp;
            }

            return res;
    }

    public static void main(String[] args) {
        new _17_LetterCombinationsofaPhoneNumber().letterCombinations("23");
    }
}
