/*
Date:05.02,2019 22:19
Given an array of size n, find the majority element.
The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/
package leetcode;

public class _169_MajorityElement {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (res == nums[i]) {
                count++;
            } else {
                count--;
                if (count < 0) {
                    res = nums[i];
                    count = 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _169_MajorityElement majorityElement = new _169_MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{6}));
    }
}
