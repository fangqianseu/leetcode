package leetcode;

/**
 * @author qianfang, at 2021/8/26, 上午12:25
 **/
/*
Given an integer array nums sorted in non-decreasing order,
remove the duplicates in-place such that each unique element appears only once.
The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages,
 you must instead have the result be placed in the first part of the array nums.

 More formally, if there are k elements after removing the duplicates,
 then the first k elements of nums should hold the final result.
 It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array.
You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class _26_Remove_Duplicates_from_Sorted_Array {
    public int best(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int i = 1;
        for (int num : nums) {
            if (num > nums[i - 1]) {
                nums[i] = num;
                i++;
            }
        }
        return i;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int l = 1;
        int r = 1;
        while (r < nums.length) {
            if (nums[r] > nums[l - 1]) {
                swap(nums, r, l);
                l++;
            }
            r++;
        }
        int res = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                res++;
            } else {
                break;
            }
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        _26_Remove_Duplicates_from_Sorted_Array remove_duplicates_from_sorted_array = new _26_Remove_Duplicates_from_Sorted_Array();
        remove_duplicates_from_sorted_array.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }
}
