/*
Date: 04/01,2019, 10:02

*/
package leetcode;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * 有断点的有序队列 查找数字
 */
public class _33_SearchingRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int midIndex = l + (r - l) / 2;
            if (nums[midIndex] == target) {
                return midIndex;
            }
            if (l == r) {
                return -1;
            }
            // midIndex在旋转点右侧  midIndex右侧有序
            if (nums[r] > nums[midIndex]) {
                // target在右侧有序范围内
                if (nums[midIndex] <= target && nums[r] >= target) {
                    l = midIndex + 1;
                } else {
                    r = midIndex - 1;
                }
            } else {
                // midIndex 在旋转点左侧， 左侧为有序
                // target在左侧侧有序范围内
                if (nums[midIndex] >= target && nums[l] <= target) {
                    r = midIndex - 1;
                } else {
                    l = midIndex + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _33_SearchingRotatedSortedArray searchingRotatedSortedArray = new _33_SearchingRotatedSortedArray();
        System.out.println(searchingRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
    }
}
