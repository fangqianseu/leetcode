package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianfang, at 2021/9/24, 上午8:25
 **/
/*
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */
public class _118PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        if (numRows == 1) {
            return res;
        }
        List<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        res.add(second);
        if (numRows == 2) {
            return res;
        }
        for (int i = 3; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> above = res.get(i - 2);
            temp.add(1);
            for (int j = 0; j < above.size() - 1; j++) {
                temp.add(above.get(j) + above.get(j + 1));
            }
            temp.add(1);
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        _118PascalTriangle pascalTriangle = new _118PascalTriangle();
        List<List<Integer>> generate = pascalTriangle.generate(5);
    }
}
