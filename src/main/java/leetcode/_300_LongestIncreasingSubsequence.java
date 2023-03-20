/*
Date:05.19,2019 22:27
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Note:
There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
*/
package leetcode;

import java.util.Arrays;

public class _300_LongestIncreasingSubsequence {
    /**
     * dp[i] 为 i之前，比numm[i]小的数字个数
     * dp[i] = max(dp[j] + 1 && num[i]>num[j]),  j in [0,i)
     * O(n^2)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = dp[0];
        for (int i : dp)
            max = Math.max(max, i);
        return max;
    }
}
