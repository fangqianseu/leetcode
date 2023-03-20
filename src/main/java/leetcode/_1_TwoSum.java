package leetcode;

/**
 * @author qianfang, at 2021/8/17, 下午11:31
 **/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class _1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (map.containsKey(t)) {
                return new int[]{map.get(t), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _1_TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
