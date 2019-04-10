/*
Date:04.09,2019 23:33

Given an array with n objects colored red, white or blue,
sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem
*/
package leetcode;

import com.sun.deploy.panel.WinUpdatePanel;

public class _75_SortColors {
    /**
     * 1.5次遍历 非最优
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int i = 0, j = nums.length - 1;
        // 将 0 全部调整到前列
        while (i < j) {
            while (i < j && nums[i] == 0) i++;
            while (i < j && nums[j] != 0) j--;
            swap(nums, i, j);
        }

        // 从 0 的下一位 调整
        j = nums.length -1;
        while (i < j) {
            while (i < j && nums[i] == 1) i++;
            while (i < j && nums[j] != 1) j--;
            swap(nums, i, j);
        }
    }

    /**
     * 最优算法 一次遍历
     * 3个指针： 0 ptr, 2ptr, now ptr
     * 当 和 2交换时， nowptr不++； 因为不能确定交换来的数 是否为 0
     * @param nums
     */
    public void sortColors2(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int lptr = 0, nowptr = 0, rptr = nums.length -1;

        while (nowptr <= rptr){
            if (nums[nowptr] == 0){
                swap(nums,nowptr,lptr);
                lptr++;
                nowptr++;
            }else if (nums[nowptr] == 2){
                swap(nums,nowptr,rptr);
                rptr--;
            }else {
                nowptr++;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        new _75_SortColors().sortColors2(new int[]{2,0,1});
    }
}
