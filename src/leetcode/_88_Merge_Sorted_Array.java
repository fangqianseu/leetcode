package leetcode;

/**
 * @author qianfang, at 2021/9/6, 上午12:05
 **/
/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 */
public class _88_Merge_Sorted_Array {
    // 逆向 从后面存储
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    // 正向存储
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        System.arraycopy(nums1, 0, temp, 0, m);
        int i = 0;
        int j = 0;
        int r = 0;
        while (m > 0 || n > 0) {
            int l1 = Integer.MAX_VALUE;
            int l2 = Integer.MAX_VALUE;
            if (m > 0) {
                l1 = temp[i];
            }
            if (n > 0) {
                l2 = nums2[j];
            }
            if (l1 <= l2) {
                nums1[r++] = l1;
                i++;
                m--;
            } else {
                nums1[r++] = l2;
                j++;
                n--;
            }
        }
    }

    public static void main(String[] args) {
        _88_Merge_Sorted_Array merge_sorted_array = new _88_Merge_Sorted_Array();
        merge_sorted_array.merge1(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{1, 4, 5}, 2);
    }
}
