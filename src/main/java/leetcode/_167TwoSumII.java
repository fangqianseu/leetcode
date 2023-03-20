package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qianfang, at 2021/9/30, 上午8:17
 **/

/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 find two numbers such that they add up to a specific target number.
  Let these two numbers be numbers[index1] and numbers[index2] where 1 <= first < second <= numbers.length.

Return the indices of the two numbers, index1 and index2, as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.
 */
public class _167TwoSumII {
    // 通用解法
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int val = numbers[i];
            if (map.containsKey(target - val)) {
                res[0] = map.get(target - val) + 1;
                res[1] = i + 1;
            } else {
                map.put(val, i);
            }
        }
        return res;
    }

    // 由于已排序 可以直接使用收尾逼迫法
    public int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        int l = 0;
        int r = numbers.length - 1;
        while (l <= r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _167TwoSumII twoSumII = new _167TwoSumII();
        twoSumII.twoSum(new int[]{2, 7, 11, 15}, 9);
    }
}
