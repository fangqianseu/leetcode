/*
Date:05.09,2019 23:04
Given a 2D binary matrix filled with 0's and 1's,
find the largest square containing only 1's and return its area.

Example:

Input:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
*/
package leetcode;

public class _221_MaximalSquare {
    private int res = 0;

    /**
     * 动态规划
     * dp[i][j] = min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j]) + 1
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, result = 0;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;
                    result = Math.max(dp[i][j], result);
                }
            }
        }
        return result * result;
    }
}
