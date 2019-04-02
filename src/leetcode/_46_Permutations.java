/*
Date:04.02,2019 22:20
Given a collection of distinct integers, return all possible permutations.
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _46_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        permuteCore(nums, 0, res);
        return res;
    }

    private void permuteCore(int[] nums, int i, ArrayList<List<Integer>> res) {
        if (i == nums.length) {
            ArrayList<Integer> t = new ArrayList<>();
            for (int item : nums) t.add(item);
            res.add(t);
            return;
        }

        for (int j = i; j < nums.length; j++) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;

            permuteCore(nums, i + 1, res);

            t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
