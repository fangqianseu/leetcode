/*
Date:04.09,2019 22:57

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.
*/
package leetcode;

public class _70_ClimbingStairs {
    /**
     * 递归法
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * dp:  dp[n] = dp[n-1] + dp[n-2]
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n < 3) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++)
            dp[i] = dp[i-2] + dp[i-1];

        return dp[n];
    }

    public static void main(String[] args) {
        _70_ClimbingStairs climbingStairs = new _70_ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(37));
        System.out.println(climbingStairs.climbStairs2(37));
    }
}
