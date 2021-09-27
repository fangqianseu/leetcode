/*
Date:04.20,2019 10:25
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
*/
package leetcode;

/*
Given a non-empty array of integers nums, every element appears twice except for one.
 Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class _136_SingleNumber {

    /*
    使用 异或  ^
    按位运算 相同为 0 相异为1
     */
    public int singleNumber(int[] nums) {
        int res = nums[0];
        if (nums.length < 2) {
            return res;
        }
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
