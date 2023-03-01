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

    /**
     * 从后向前查找第一个相邻升序的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
     * 在 [j,end) 从后向前查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
     * 将 A[i] 与 A[k] 交换
     * 可以断定这时 [j,end) 必然是降序，逆置 [j,end)，使其升序
     * 如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4
     * <p>
     * 作者：imageslr
     * 链接：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        // 从右到左 找到第一个非递增的下标
        int index = nums.length - 1;
        while (index > 0 && nums[index - 1] >= nums[index]) {
            index--;
        }
        // 如果index为0 则说明数组为递减序列 直接翻转就好
        if (index < 1) {
            reserve(nums, 0, nums.length - 1);
            return;
        }

        // 此时  [index-1,index]为递增  【index,end]为递减

        // 在【index,end]中 从有道做 选择第一个大于 num[index-1]的值 和 index-1交换
        int t = nums[index - 1];
        for (int i = nums.length - 1; i >= index; i--) {
            if (nums[i] > t) {
                swap(nums, i, index - 1);
                break;
            }
        }

        //剩下的 [index,end] 仍然为递减序列  翻转就好
        reserve(nums, index, nums.length - 1);
    }

    private void reserve(int[] nums, int l, int r) {
        for (; l < r; l++, r--) {
            swap(nums, l, r);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
//        new _31_NextPermutation().nextPermutation(new int[]{1, 2, 3, 4, 6, 5});
//        new _31_NextPermutation().nextPermutation(new int[]{3, 2, 1});
        new _31_NextPermutation().nextPermutation(new int[]{5, 1, 1});
    }
}
