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
     * dp[i][j] 表示从i到j的乘积
     * dp[i][j] = dp[i][j-1] * num[j]
     * 可用 pre代替dp[i][j-1]， 优化空间
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++)
            for (int j = i; j < nums.length; j++) {
                if (i == j)
                    dp[i][j] = nums[i];
                else
                    dp[i][j] = nums[j] * dp[i][j - 1];
                res = Math.max(res, dp[i][j]);
            }
        return res;
    }

    /**
     * max 保存最大值情况
     * min 保存最小值，有负数 则变成最大
     * @param nums
     * @return
     */
    public int maxProduct2(int[] nums) {
        int res = nums[0];
        int max = nums[0],min = nums[0];

        for (int i = 1; i < nums.length ;i++){
            if (nums[i] < 0){
                int t = max;
                max = min;
                min = t;
            }
            max = Math.max(max*nums[i],nums[i]);
            min = Math.min(min*nums[i],nums[i]);

            if (max > res)
                res = max;
        }

        return res;
    }
    public static void main(String[] args) {
        new _152_MaximumProductSubarray().maxProduct(new int[]{2, 3, -2, 4});
    }
}
