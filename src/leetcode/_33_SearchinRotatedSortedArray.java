/*
Date: 04/01,2019, 10:02

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
You are given a target value to search. If found in the array return its index, otherwise return -1.
*/
package leetcode;

public class _33_SearchinRotatedSortedArray {
    int[] nums = null;

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        this.nums = nums;
        return quickSort(target, 0, nums.length - 1);
    }

    // 将 mid 固定在 确定 有序 的一段上比较
    private int quickSort(int target, int l, int r) {
        int mid = (l + r) / 2;
        if (nums[mid] == target)
            return mid;
        if (l >= r) return -1;

        if (nums[mid] > nums[r]) { // 在旋转点前半段
            if (nums[l] <= target && target <= nums[mid]) {
                return quickSort(target, l, mid - 1);
            } else {
                return quickSort(target, mid + 1, r);
            }
        } else {    // 在旋转点后半段
            if (nums[mid] <= target && target <= nums[r])
                return quickSort(target, mid + 1, r);
            else return quickSort(target, l, mid - 1);
        }
    }
}
