/*
Date:04.08,2019 22:41

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

*/
package leetcode;

public class _62_UniquePaths {
    int res = 0;

    // 回溯法 超时
    public int uniquePaths(int m, int n) {
        boolean[][] signs = new boolean[m][n];
        int i = 0, j = 0;
        signs[i][j] = true;
        uniquePathsCore(m - 1, n - 1, signs, i, j);

        return res;
    }

    private void uniquePathsCore(int m, int n, boolean[][] signs, int i, int j) {
        if (i == m && j == n) {
            res++;
            return;
        }
        if (i + 1 <= m && !signs[i + 1][j]) {
            signs[i + 1][j] = true;
            uniquePathsCore(m, n, signs, i + 1, j);
            signs[i + 1][j] = false;
        }
        if (j + 1 <= n && !signs[i][j + 1]) {
            signs[i][j + 1] = true;
            uniquePathsCore(m, n, signs, i, j + 1);
            signs[i][j + 1] = false;
        }
    }

    /**
     * 动态规划
     * dp[i][j] 为 (i,j) 上的路径可能数
     * 第一行 第一列 要初始化为1
     * dp[i][j] = dp[i-1][j] + dp[i][j-1]
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];

        // 将 最上行 和 最左行 初始化为1
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        // 逐行计算dp的值
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // 返回终点路径数
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int i = new _62_UniquePaths().uniquePaths2(23, 12);
        int j = new _62_UniquePaths().uniquePaths(23, 12);
        System.out.println(i);
        System.out.println(j);
    }
}
