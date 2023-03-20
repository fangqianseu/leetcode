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
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }

    public static void main(String[] args) {
        _136_SingleNumber singleNumber = new _136_SingleNumber();
        System.out.println(singleNumber.singleNumber(new int[]{1, 1, 2,2,3}));
    }
}
