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
        helper(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] candidates, int i, int target, List<Integer> current, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }
        if (i >= candidates.length) {
            return;
        }
        if (target < candidates[i]) {
            return;
        }
        for (int index = i; index < candidates.length && target >= candidates[index]; index++) {
            if (target >= candidates[index]) {
                current.add(candidates[index]);
                helper(candidates, index, target - candidates[index], current, res);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        _39_CombinationSum combinationSum = new _39_CombinationSum();
        combinationSum.combinationSum(new int[]{2, 3, 4}, 8);
    }
}
