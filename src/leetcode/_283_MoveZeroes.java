/*
Date:05.16,2019 22:54
Given an array nums, write a function to move all 0's to the end of
it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/
package leetcode;

public class _283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index0++] = nums[i];
            }
        }
        for (; index0 < nums.length; index0++) {
            nums[index0] = 0;
        }
    }
}
