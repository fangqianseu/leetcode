package leetcode;

/**
 * @author qianfang, at 2021/8/27, 上午12:57
 **/
/*
Given an integer array nums and an integer val,
remove all occurrences of val in nums in-place.
The relative order of the elements may be changed.


 */
public class _27_Remove_Element {
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    /*
     l 为和 val 相等的 下标
     r 为和 val 不相等的 下标
     找到后 交换2个位置
     */
    public int removeElement(int[] nums, int val) {
        int l = 0;
        int r = nums.length - 1;
        while (r >= l) {
            while (l < nums.length && nums[l] != val) {
                l++;
            }
            while (r >= 0 && nums[r] == val) {
                r--;
            }
            if (r >= l && l < nums.length && r > 0) {
                swap(nums, l, r);
            }
        }
        return l;
    }

    private void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }

    public static void main(String[] args) {
        _27_Remove_Element remove_element = new _27_Remove_Element();
        remove_element.removeElement2(new int[]{1, 2, 3, 4, 4, 5}, 4);
    }
}
