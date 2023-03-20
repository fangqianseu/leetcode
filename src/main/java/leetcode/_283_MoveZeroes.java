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

    /**
     * 把非0的元素往前移，剩余的用0填
     */
    public void bestMove(int[] nums) {
        int index0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index0] = nums[i];
                index0++;
            }
        }
        for (; index0 < nums.length; index0++) {
            nums[index0] = 0;
        }
    }

    public void moveZeroes(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] nums, int j, int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        _283_MoveZeroes moveZeroes = new _283_MoveZeroes();
        moveZeroes.moveZeroes(new int[]{0});
    }
}
