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
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                return mid;
            }
        }
        return nums[l] > target ? l : l + 1;
    }

    /*
     O(n)方法
     */
    public int searchInsert(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                break;
            } else {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _35_Search_Insert_Position search_insert_position = new _35_Search_Insert_Position();
        System.out.println(search_insert_position.searchInsertBest(new int[]{1}, 2));
    }
}
