/*
Date:05.08,2019 22:57
Find the kth largest element in an unsorted array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
*/
package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _215_KthLargestElementinanArray {
    public static void main(String[] args) {
        new _215_KthLargestElementinanArray().findKthLargest2(new int[]{-1, 2, 0}, 3);
    }

    /**
     * 最大堆
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int n : nums) {
            queue.offer(n);
        }
        while (--k > 0)
            queue.poll();
        return queue.peek();
    }

    /**
     * 改进快排
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k - 1);
    }

    private int quickSort(int[] nums, int l, int r, int k) {
        int index = Integer.MIN_VALUE;
        while (index != k) {
            int begin = l, end = r;
            int temp = nums[end];
            while (begin < end) {
                while (begin < end && nums[begin] >= temp) begin++;
                nums[end] = nums[begin];
                while (begin < end && nums[end] <= temp) end--;
                nums[begin] = nums[end];
            }
            nums[begin] = temp;

            index = begin;
            if (begin < k)
                l = begin + 1;
            else if (begin > k)
                r = begin - 1;
        }
        return nums[index];
    }

    private void swap(int[] nums, int begin, int end) {
        int t = nums[begin];
        nums[begin] = nums[end];
        nums[end] = t;
    }
}
