/*
Date:05.15,2019 23:27
Given a positive integer n, find the least number of perfect square numbers
(for example, 1, 4, 9, 16, ...) which sum to n.

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
*/
package leetcode;

import java.util.Arrays;

public class _279_PerfectSquares {
    /**
     * dp[i] 为 n = i 时的组成最小数
     * dp[i] = min{dp[i - j*j] + 1}, i - j*j>= 0
     * 即为 i 减去一个 平方数 加一
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int j =1;
            while (i - j*j >=0){
                dp[i] = Math.min(dp[i- j*j] + 1,dp[i]);
                j++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new _279_PerfectSquares().numSquares(12);
    }
}
