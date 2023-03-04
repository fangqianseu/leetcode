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
        List<List<Integer>> res = new ArrayList<>();
        permuteCore(nums, 0, new ArrayList<>(), new ArrayList<>(), res);
        return res;
    }

    private void permuteCore(int[] nums, int i, List<Integer> used, List<Integer> current, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }
        for (int num : nums) {
            if (!used.contains(num)) {
                used.add(num);
                current.add(num);
                permuteCore(nums, i + 1, used, current, res);
                current.remove(current.size() - 1);
                used.remove(used.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        new _46_Permutations().permute(new int[]{1, 2, 3});

    }
}
