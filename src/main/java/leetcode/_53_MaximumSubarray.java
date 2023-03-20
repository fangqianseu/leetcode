/*
Date:04.07,2019 21:32

Given an integer array nums, find the contiguous subarray
(containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
*/
package leetcode;

public class _53_MaximumSubarray {
    /*
    Given an integer array nums, find the contiguous subarray (containing at least one number)
    which has the largest sum and return its sum.
    A subarray is a contiguous part of an array.
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // temp 为 当前值   和 之前积累的和加上当前值 中 最大的那一个
            temp = Math.max(nums[i], temp + nums[i]);
            res = Math.max(res, temp);
        }
        return res;
    }

    public static void main(String[] args) {
        _53_MaximumSubarray maximumSubarray = new _53_MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
