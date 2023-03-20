package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qianfang, at 2021/8/22, 上午12:14
 **/
/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together.
12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right.
 However, the numeral for four is not IIII.
 Instead, the number four is written as IV.
  Because the one is before the five we subtract it making four.
  The same principle applies to the number nine, which is written as IX.
  There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.
 */
public class _13_Roman_to_Integer {

    /*
    从后向前处理
    如果前一位比后一位大 则减；
    否则 就加
     */
    public int romanToInt(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        res += map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                res += map.get(s.charAt(i));
            } else {
                res -= map.get(s.charAt(i));
            }
        }
        return res;
    }

    /*
        原始的方法 批量替换
     */
    public int romanToIntOrigin(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i + 1 < s.length()) {
                String prefx = s.substring(i, i + 2);
                if (prefx.equals("IV")) {
                    res += 4;
                    i++;
                    continue;
                } else if (prefx.equals("IX")) {
                    res += 9;
                    i++;
                    continue;
                } else if (prefx.equals("XL")) {
                    res += 40;
                    i++;
                    continue;
                } else if (prefx.equals("XC")) {
                    res += 90;
                    i++;
                    continue;
                } else if (prefx.equals("CD")) {
                    res += 400;
                    i++;
                    continue;
                } else if (prefx.equals("CM")) {
                    res += 900;
                    i++;
                    continue;
                }
            }
            if (c == 'I') {
                res += 1;
            } else if (c == 'V') {
                res += 5;
            } else if (c == 'X') {
                res += 10;
            } else if (c == 'L') {
                res += 50;
            } else if (c == 'C') {
                res += 100;
            } else if (c == 'D') {
                res += 500;
            } else if (c == 'M') {
                res += 1000;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _13_Roman_to_Integer roman_to_integer = new _13_Roman_to_Integer();
        System.out.println(roman_to_integer.romanToInt("XXIVI"));
    }
}
