/*
Date: 03/25,2019, 21:33

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
下一个自然增长序列
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/
package leetcode;

public class _31_NextPermutation {
    public static void main(String[] args) {
        new _31_NextPermutation().nextPermutation(new int[]{2, 5, 4});
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;

        // index 为 从后向前 第一个 非递增 下标
        int index = nums.length - 1;
        for (; index - 1 >= 0 && nums[index - 1] >= nums[index]; index--) {
        }

        // 没有下一组 则返回字母序
        if (index == 0) {
            reserse(nums, 0);
            return;
        }

        for (int i = nums.length - 1; i >= index; i--) {
            if (nums[i] > nums[index - 1]) {
                int temp = nums[index - 1];
                nums[index - 1] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        // 其实交换之后 index 之后的序列为降序排列 直接 reserve 即可
        reserse(nums, index);
    }

    private void reserse(int[] nums, int index) {
        for (int l = index, r = nums.length - 1; l < r; l++, r--) {
            int t = nums[r];
            nums[r] = nums[l];
            nums[l] = t;
        }
    }
}
