package leetcode;

/**
 * by qianfang, at 2019-08-04, 15:39
 * <p>
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order, too.
 * <p>
 * You need to find the shortest such subarray and output its length.
 * <p>
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 **/
public class _581_ShortestUnsortedContinuousSubarray {
    /**
     * 思路： 前部上升，找到第一个下降点之后的最小值；
     * 后部下降，找到第一个下降点之前的最大值
     * 排序子串在 从前向后 第一个大于min 到 从后向前 第一个小于max 之间
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        if (null == nums || nums.length == 1)
            return 0;

        // 升序的第一次下降点
        int l = 0;
        for (; l + 1 < nums.length; l++) {
            if (nums[l] > nums[l + 1]) {
                break;
            }
        }

        // 寻找之后的最小值
        int min = nums[nums.length - 1];
        for (l++; l < nums.length; l++) {
            min = Math.min(min, nums[l]);
        }
        for (l = 0; l < nums.length && nums[l] <= min; l++) {
        }
        l--;

        // 数组从后向前第一个上升点
        int r = nums.length - 1;
        for (; r - 1 >= 0; r--) {
            if (nums[r - 1] > nums[r]) {
                break;
            }
        }
        // 寻找之前的最大值
        int max = nums[0];
        for (; r >= 0; r--) {
            max = Math.max(max, nums[r]);
        }
        for (r = nums.length - 1; r >= 0 && nums[r] >= max; r--) {
        }
        r++;
        return r > l ? r - l - 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(new _581_ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{1, 2, 3, 4}));
    }
}
