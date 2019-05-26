/*
Date:05.26,2019 22:09
You are given coins of different denominations and a total amount of money amount.
Write a function to compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Note:
You may assume that you have an infinite number of each kind of coin.
*/
package leetcode;

public class _322_CoinChange {
    int res = -1;

    /**
     * 递归做法
     * 时间复杂度最高
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0)
            return -1;

        helper(coins, amount, 0);
        return res;
    }

    private void helper(int[] coins, int remain, int count) {
        if (remain == 0) {
            if (res == -1) {
                res = count;
            } else {
                res = Math.min(res, count);
            }
            return;
        } else if (remain < 0)
            return;

        for (int item : coins) {
            helper(coins, remain - item, count + 1);
        }
    }

    /**
     * 动态规划
     * dp[i] 为 amount为i时，所用的coin数
     * dp[i] = min[dp[j] + 1], j = [1,i] 切 dp[i-j] != -1
     * 即 观察 i-coin 对应的数 是否能够配齐
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0)
            return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int res = Integer.MAX_VALUE;

            // 逆推1个硬币之前的dp
            for (int item : coins) {
                if (i >= item && dp[i - item] >= 0) {
                    res = Math.min(dp[i - item] + 1, res);
                }
            }

            if (res == Integer.MAX_VALUE)
                dp[i] = -1;
            else
                dp[i] = res;
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        new _322_CoinChange().coinChange2(new int[]{5, 2}, 10);
    }
}
