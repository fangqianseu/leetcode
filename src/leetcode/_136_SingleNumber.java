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

public class _136_SingleNumber {
    /**
     * 利用 异或 运算
     * 扩展： 找出2个 只出现一次的数字(剑指offer)
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++)
            res ^= nums[i];

        return res;
    }
}
