/*
Date:05.18,2019 22:38
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
 find the duplicate one.

Example 1:
Input: [1,3,4,2,2]
Output: 2

Example 2:
Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
*/
package leetcode;

public class _287_FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        boolean[] signs = new boolean[nums.length + 1];
        for (int i : nums) {
            if (signs[i])
                return i;
            signs[i] = true;
        }
        return 0;
    }

    /**
     * 二分法
     * 计算 low 到 mid 之间数字的总数 count
     * 如果 count > mid, 则重复数字在 low~mid之间
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        int low = 1, high = nums.length - 1, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid)
                    count++;
            }
            if (count > mid)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        new _287_FindtheDuplicateNumber().findDuplicate2(new int[]{2, 8, 7, 6, 5, 4, 9, 1, 3, 2});
    }
}
