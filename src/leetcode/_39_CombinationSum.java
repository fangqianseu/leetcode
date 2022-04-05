package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * <p>
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations
 * for the given input.
 */
public class _39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> current = new ArrayList<>();
        helper(candidates, 0, target, current, res);
        return res;
    }

    private void helper(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> res) {
        if (index >= candidates.length) {
            return;
        }
        if (target == 0) {
            // 不能直接传 current，这个对象是可变的
            res.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                i++;
            }
            current.add(candidates[i]);
            helper(candidates, i, target - candidates[i], current, res);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        _39_CombinationSum combinationSum = new _39_CombinationSum();
        combinationSum.combinationSum(new int[]{2, 3, 4}, 8);
    }
}
