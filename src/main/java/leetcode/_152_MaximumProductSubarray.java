/*
Date:04.28,2019 23:54

Given an integer array nums, find the contiguous subarray within an array
(containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
*/
package leetcode;

public class _152_MaximumProductSubarray {
    /**
     * nums[i] 有正有负，需要同时保存 当前位置 最大 最小的值
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(min[i - 1] * nums[i], nums[i]));
            min[i] = Math.min(max[i - 1] * nums[i], Math.min(min[i - 1] * nums[i], nums[i]));
            res = Math.max(res, max[i]);
        }
        return res;
    }

    /**
     * max 保存最大值情况
     * min 保存最小值，有负数 则变成最大
     *
     * @param nums
     * @return
     */
    public int maxProduct2(int[] nums) {
        int res = nums[0];
        int max = nums[0], min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int t = max;
                max = min;
                min = t;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);

            if (max > res)
                res = max;
        }

        return res;
    }

    public static void main(String[] args) {
        new _152_MaximumProductSubarray().maxProduct(new int[]{2, 3, -2, 4});
    }
}
