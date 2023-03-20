/*
Date:05.13,2019 22:50
Given an array nums of n integers where n > 1,  return an array output such that
output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).
*/
package leetcode;

import java.util.HashSet;

public class _238_ProductofArrayExceptSelf {

    /**
     * bset solution
     * 二次遍历 一次计算 i 之前的积
     * 一次计算 i 之后的积
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf_best(int[] nums) {
        int[] res = new int[nums.length];

        // res[i] 为 i之前 所有数之积
        int t = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = t;
            t = t * nums[i];
        }

        // res[i] 为 i之后 所有数之积
        t = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= t;
            t = t * nums[i];
        }

        return res;
    }

    /**
     * first solution
     * 记录 0 的情况
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int multy = 1;
        HashSet<Integer> zeros = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros.add(i);
            } else
                multy *= nums[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zeros.size() == 0) {
                res[i] = multy / nums[i];
            } else if (zeros.size() == 1 && zeros.contains(i)) {
                res[i] = multy;
            } else
                res[i] = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        new _238_ProductofArrayExceptSelf().productExceptSelf(new int[]{1, 0});
    }
}
