/*
Date:05.02,2019 22:19
Given an array of size n, find the majority element.
The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/
package leetcode;

public class _169_MajorityElement {
    public int majorityElement(int[] nums) {
        int main = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == main) {
                count++;
            } else if (--count < 0) {
                count = 1;
                main = nums[i];
            }
        }

        return main;
    }

    public static void main(String[] args) {
        new _169_MajorityElement().majorityElement(new int[]{6, 5, 5});
    }
}
