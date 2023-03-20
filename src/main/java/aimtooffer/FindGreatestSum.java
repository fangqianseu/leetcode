package aimtooffer;

/**
 * @author qianfang, at 2019-09-16, 09:11
 * <p>
 * 给一个数组，返回它的最大连续子序列的和
 **/
public class FindGreatestSum {
    // 动态规划 dp[i] = 包含 array[i]位置的最大子串和
    public int findGreatestSum(int[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }
        int[] dp = new int[array.length + 1];
        dp[0] = 0;
        int res = array[0];

        for (int i = 0; i < array.length; i++) {
            dp[i + 1] = Math.max(dp[i] + array[i], array[i]);
            res = Math.max(res, dp[i + 1]);
        }

        return res;
    }

    public int findGreatestSum2(int[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }

        int sum = array[0], res = sum;
        for (int i = 1; i < array.length; i++) {
            sum = sum + array[i];
            res = Math.max(res, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        return res;
    }
}
