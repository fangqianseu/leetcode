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
    /**
     * 最初的算法，2次hashmap
     *
     * @param nums
     * @param k
     * @return
     */
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

    /**
     * 利用 bitmap， 减少对 频率的排序
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent_array(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : nums) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (bucket[entry.getValue()] == null)
                bucket[entry.getValue()] = new ArrayList<>();
            bucket[entry.getValue()].add(entry.getKey());
        }

        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; res.size() < k && i >= 0; i--) {
            if (bucket[i] != null)
                res.addAll(bucket[i]);
        }

        return res;
    }

    /**
     * 利用 priorityQueue， 对 entry 排序
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent_priority(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : nums) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(entry);
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (res.size() < k){
            res.add(priorityQueue.poll().getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        new _347_TopKFrequentElements().topKFrequent(new int[]{1, 2}, 2);
    }
}
