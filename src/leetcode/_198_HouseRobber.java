/*
Date:05.03,2019 22:20
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed, the only constraint stopping you from robbing
 each of them is that adjacent houses have security system connected and it
 will automatically contact the police if two adjacent houses were broken into on the same night.
不能连续抢劫相邻的屋子，求最大值

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
*/
package leetcode;

public class _198_HouseRobber {
    /**
     * dp[i] = max(dp[i-1] , nums[i]+dp[i-2])
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (i == 1)
                dp[i] = Math.max(nums[i], dp[i - 1]);
            else
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
}
