/*
Date:06.02,2019 12:08

Equations are given in the format A / B = k, where A and B are variables represented as strings,
and k is a real number (floating point number). Given some queries, return the answers.
If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].
*/
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _399_EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 关系图 1对多
        HashMap<String, List<String>> relation = new HashMap<>();
        // 每一条边的值
        HashMap<String, Double> relationValue = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            double value = values[i];
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            // 新的节点 添加本身
            if (!relation.containsKey(a)) {
                relation.put(a, new ArrayList<String>());
                relationValue.put(a + a, 1.0);
            }
            if (!relation.containsKey(b)) {
                relation.put(b, new ArrayList<String>());
                relationValue.put(b + b, 1.0);
            }

            relation.get(a).add(b);
            relationValue.put(a + b, value);

            relation.get(b).add(a);
            relationValue.put(b + a, 1 / value);
        }

        double[] res = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);

            double r = dfs(a, b, 1.0, relation, relationValue, new HashSet<String>());

            if (r == 0.0)
                res[i] = -1.0;
            else
                res[i] = r;
        }

        return res;
    }

    // 深度优先遍历 使用set 保存已经遍历的边集合
    private double dfs(String begin, String target, double v, HashMap<String, List<String>> relation, HashMap<String, Double> relationValue, HashSet<String> hasFind) {
        if (hasFind.contains(begin) || !relation.containsKey(begin))
            return 0.0;
        if (target.equals(begin))
            return v;

        hasFind.add(begin);

        List<String> list = relation.get(begin);
        double r = -1;
        for (int i = 0; i < list.size(); i++) {
            String key = list.get(i);
            r = dfs(key, target, v * relationValue.get(begin + key), relation, relationValue, hasFind);
            if (r != 0.0)
                break;
        }

        return r;
    }
}
