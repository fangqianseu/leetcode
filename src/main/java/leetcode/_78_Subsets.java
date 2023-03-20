/*
Date:04.10,2019 23:00

Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.

Example:
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/
package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
注意 子集 和 排列( Leetcode-46 ) 不同：
排列是每次交换元素的位置，递归是 从 index + 1 ；
子集是每次添加元素，然后删除, 递归是 从 i + 1 ；
 */
public class _78_Subsets {
    /**
     * 逐个枚举，空集的幂集只有空集，每增加一个元素，让之前幂集中的每个集合，追加这个元素，就是新增的子集
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        for (int item : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(res.get(i));
                subset.add(item);
                res.add(subset);
            }
        }
        return res;
    }

    /**
     * 递归解法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        subsets2Core(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    private void subsets2Core(ArrayList<List<Integer>> res, ArrayList<Integer> list, int[] nums, int index) {

        res.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            subsets2Core(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        new _78_Subsets().subsets2(new int[]{1, 2, 3});
    }
}
