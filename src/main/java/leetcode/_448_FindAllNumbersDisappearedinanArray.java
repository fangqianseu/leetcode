package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * write by qianfang, at 2019.8.3, 16:12
 * <p>
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice
 * and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [5,6]
 */
public class _448_FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] sign = new boolean[nums.length + 1];

        for (int i : nums) {
            sign[i] = true;
        }

        // 注意 此处 i <= nums.length !!!
        for (int i = 1; i <= nums.length; i++) {
            if (!sign[i]) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = new _448_FindAllNumbersDisappearedinanArray().findDisappearedNumbers(
                new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(result);
    }
}
