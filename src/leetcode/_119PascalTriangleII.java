package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qianfang, at 2021/9/24, 上午8:37
 **/

/*
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

 */
public class _119PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if (rowIndex < 1) {
            return res;
        }
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> newArray = new ArrayList<>();
            for (int j = 0; j <= res.size(); j++) {
                if (j == 0 || j == res.size()) {
                    newArray.add(1);
                } else {
                    newArray.add(res.get(j) + res.get(j - 1));
                }
            }
            res = newArray;
        }
        return res;
    }

    /*
    直接分配好一行空间
    从后往前处理
     */
    public List<Integer> getRowBest(int rowIndex) {
        Integer[] res = new Integer[rowIndex + 1];
        Arrays.fill(res, 0);
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            // j大于0 因为第一位永远是1
            for (int j = i; j > 0; j--) {
                res[j] = res[j - 1] + res[j];
            }
        }
        return Arrays.asList(res);
    }

    public static void main(String[] args) {
        _119PascalTriangleII pascalTriangleII = new _119PascalTriangleII();
        pascalTriangleII.getRow(3);
    }
}
