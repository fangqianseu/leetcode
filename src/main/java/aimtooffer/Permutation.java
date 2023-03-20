package aimtooffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author qianfang, at 2019-09-12, 10:48
 * <p>
 * 输入一个字符串,按 字典序 打印出该字符串中字符的所有排列
 **/
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.trim().length() == 0) {
            return res;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        helper(chars, 0, chars.length, res);
        Collections.sort(res);
        return res;
    }

    private void helper(char[] chars, int l, int r, ArrayList<String> res) {
        if (l >= r) {
            res.add(String.valueOf(chars));
            return;
        }

        // chars里可能含有重复元素 set去重
        HashSet<Character> set = new HashSet<>();
        for (int i = l; i < r; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);

            swap(chars, l, i);
            helper(chars, l + 1, r, res);
            swap(chars, l, i);
        }
    }

    private void swap(char[] chars, int l, int r) {
        char c = chars[l];
        chars[l] = chars[r];
        chars[r] = c;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        System.out.println(permutation.Permutation("aabc"));
    }
}
