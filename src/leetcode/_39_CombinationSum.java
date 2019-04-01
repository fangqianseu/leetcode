/*
Date: 04/1,2019, 21:33
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.
*/
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39_CombinationSum {
    int[] candidates;

    /*
    1. 数组首先排序
    2. 回溯法 在上次添加的index 之后寻找
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        this.candidates = candidates;

        ArrayList<Integer> list = new ArrayList<>();
        combinationSumCore(list, 0, target, res);

        return res;
    }

    private void combinationSumCore(ArrayList<Integer> list, int index, int target, ArrayList<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }

        for (int i = index; i < candidates.length; i++) {
            if (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) continue;
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                combinationSumCore(list, i, target - candidates[i], res);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        new _39_CombinationSum().combinationSum(new int[]{8, 7, 4, 3}, 11);
    }
}
