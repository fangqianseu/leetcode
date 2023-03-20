/*
Date:04.07,2019 21:37
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:
Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

*/
package leetcode;

public class _55_JumpGame {

    /**
     * 第一次思考
     * <p>
     * 1. 采用dp  dp[i]为i 位置上 最大能够到达的index, dp[i] = max(dp[i-1],i + nums[i])
     * 2. 特殊点 dp[0] = 0;
     * 3. 当 dp[i] = i 且 i+1 <= nums.length 即 i 后面还有 位置时， 返回false
     * 4, 其他 返回 true
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        // 计算每一个位置到达的最大距离
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(i + nums[i], dp[i - 1]);
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果不是末尾 切可到达数不大于当前的indx 则返回false
            if (i != nums.length - 1 && dp[i] <= i) {
                return false;
            }
        }
        return true;
    }

    /**
     * 参考 leetcode 中的最优解法
     * <p>
     * 由于只保留 dp[i], 可以只保留当前的i 的 max reach
     *
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        int max = nums[0];
        // 每次更新 max，直到 max < i
        for (int i = 0; i < nums.length && max >= i; i++) {
            max = Math.max(max, nums[i] + i);
        }
        // 判断 max 是否 到达数组最后一位
        return max >= nums.length - 1;
    }

    public static void main(String[] args) {
        new _55_JumpGame().canJump(new int[]{3, 2, 1, 0, 4});
    }
}
