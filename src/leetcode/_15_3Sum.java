/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3Sum {
    /*
    1. i，l r 需要去重
    2。 不能提前跳出循环
     */
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int sum = -nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == sum) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));

                    while (l < r && nums[l + 1] == nums[l]) l++;
                    while (r > l && nums[r - 1] == nums[r]) r--;

                    l++;
                    r--;
                } else if (nums[l] + nums[r] < sum)
                    l++;
                else r--;
            }

            while (i + 1 < nums.length - 2 && nums[i + 1] == nums[i]) i++;
        }
        return res;
    }

    public static void main(String[] args) {
        new _15_3Sum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
