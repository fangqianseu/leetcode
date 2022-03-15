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
        if (null == nums || nums.length < 1) {
            return;
        }
        int r = nums.length - 1 - 1;
        // 寻找走又想着 第一个 非递增数列 的下标 即 r下标的为 最小数
        for (; r >= 0; r--) {
            if (nums[r] < nums[r + 1]) {
                break;
            }
        }

        // r下标小于0 证明整个数列为递减数列，返回递增数列 即数组从0开始翻转
        if (r < 0) {
            reverse(nums, 0);
            return;
        }

        // 从右向左 找出第一个大于下标 r 的数字 交换它和r下标的顺序
        for (int i = nums.length - 1; i > r; i--) {
            if (nums[i] > nums[r]) {
                int temp = nums[i];
                nums[i] = nums[r];
                nums[r] = temp;
                break;
            }
        }
        reverse(nums, r + 1);
    }

    // 翻转 数组 r下标 之后的数字顺序
    private void reverse(int[] nums, int r) {
        for (int i = r, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
//        new _31_NextPermutation().nextPermutation(new int[]{1, 2, 3, 4, 6, 5});
//        new _31_NextPermutation().nextPermutation(new int[]{3, 2, 1});
        new _31_NextPermutation().nextPermutation(new int[]{1, 3, 2});
    }
}
