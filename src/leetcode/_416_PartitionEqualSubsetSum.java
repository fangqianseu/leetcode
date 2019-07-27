package leetcode;

/**
 * author: fangqian
 * date: 2019-07-27
 * <p>
 * Given a non-empty array containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * <p>
 * Input: [1, 5, 11, 5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11]
 */

public class _416_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (null == nums || nums.length == 0)
            return false;

        // 如果可以划分，则和必为偶数
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (0 != sum % 2)
            return false;

        // 若可以划分，则每个集合的和为 sum/2
        int target = sum / 2;
        /**
         *  dp[i] 含义为是否有和为 i 的集合,生成一个 [0,1,...,target]的dp， dp[0] = true
         *  对于输入每一个数，改变可以达成的集合，若输入2，则 dp[2] = true
         *  结果则为 dp[target]是否为true：
         *      表明有集合和为sum，则剩下的集合和为 sum - target = target
         */
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            // 注意 从后向前遍历
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        _416_PartitionEqualSubsetSum partitionEqualSubsetSum = new _416_PartitionEqualSubsetSum();
        partitionEqualSubsetSum.canPartition(new int[]{1, 5, 11, 5});
    }
}
