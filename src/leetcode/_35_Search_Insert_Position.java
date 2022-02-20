package leetcode;

/**
 * @author qianfang, at 2021/8/31, 下午11:25
 **/
/*
Given a sorted array of distinct integers and a target value,
 return the index if the target is found. If not,
 return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
 */
public class _35_Search_Insert_Position {
    public int searchInsertBest(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        // 二分查找
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        // j有可能小于0
        if (j < 0){
            j++;
        }

        return nums[j] >= target ? j : j + 1;

    }


    public static void main(String[] args) {
        _35_Search_Insert_Position search_insert_position = new _35_Search_Insert_Position();
        System.out.println(search_insert_position.searchInsertBest(new int[]{1,3}, 1));
    }
}
