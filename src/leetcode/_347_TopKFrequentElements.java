/*
Date:05.29,2019 23:19
Given a non-empty array of integers, return the k most frequent elements.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]
*/
package leetcode;

import java.util.*;

public class _347_TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item : nums) {
            if (map.containsKey(item))
                map.put(item, map.get(item) + 1);
            else
                map.put(item, 1);
        }

        Map<Integer, List<Integer>> keys = new HashMap<>();
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            if (!keys.containsKey(entry.getValue()))
                keys.put(entry.getValue(), new ArrayList<Integer>());
            keys.get(entry.getValue()).add(entry.getKey());
        }

        List<Integer> sorts = new ArrayList<>();
        for (Integer item : keys.keySet())
            sorts.add(item);

        Collections.sort(sorts, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        List<Integer> res = new ArrayList<>();
        for (int i = 0; k > 0; i++) {
            k -= keys.get(sorts.get(i)).size();
            res.addAll(keys.get(sorts.get(i)));
        }
        return res;
    }

    public static void main(String[] args) {
        new _347_TopKFrequentElements().topKFrequent(new int[]{1, 2}, 2);
    }
}
