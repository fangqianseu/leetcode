/*
Date: 04/01,2019, 10:50

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].
*/
package leetcode;

public class _34_FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (nums == null || nums.length == 0) return res;

        res[0] = leftfind(nums, 0, nums.length - 1, target);
        res[1] = rightfind(nums, 0, nums.length - 1, target);

        return res;
    }

    // 相等时 也让 mid 变化
    private int leftfind(int[] nums, int l, int r, double target) {
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else
                l = mid + 1;
            if (nums[mid] == target)
                res = mid;
        }
        return res;
    }

    private int rightfind(int[] nums, int l, int r, double target) {
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else
                r = mid - 1;
            if (nums[mid] == target)
                res = mid;
        }
        return res;
    }

    public static void main(String[] args) {
        new _34_FindFirstandLastPositionofElementinSortedArray().searchRange(new int[]{5,7,7,8,8,10}, 8);
    }
}
