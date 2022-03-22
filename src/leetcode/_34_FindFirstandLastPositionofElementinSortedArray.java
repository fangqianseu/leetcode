/*
Date: 04/01,2019, 10:50
*/
package leetcode;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of
 * a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 */
public class _34_FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (null == nums || nums.length == 0) {
            return res;
        }
        res[0] = findLeft(nums, target);
        res[1] = findRight(nums, target);
        return res;
    }

    private int findRight(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int temp = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;

            } else {
                r = mid - 1;
            }
            if (nums[mid] == target) {
                temp = mid;
            }
        }
        return temp;
    }

    private int findLeft(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int temp = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

            if (nums[mid] == target) {
                temp = mid;
            }
        }
        return temp;
    }


    public static void main(String[] args) {
        _34_FindFirstandLastPositionofElementinSortedArray elementinSortedArray = new _34_FindFirstandLastPositionofElementinSortedArray();
        int[] ints = elementinSortedArray.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
