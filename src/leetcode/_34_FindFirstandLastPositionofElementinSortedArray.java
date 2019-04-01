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

        res[0] = halfFind(nums, 0, nums.length - 1, target - 0.5);
        res[1] = halfFind(nums, 0, nums.length - 1, target + 0.5) - 1;

        return res;
    }

    private int halfFind(int[] nums, int l, int r, double target) {
        if (l > r) return -1;
        if (l == r) return -1;

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("lajsdlasjd");
    }
}
