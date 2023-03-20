/*
Date:04.13,2019 23:07
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/
package leetcode;

public class _96_UniqueBinarySearchTrees {
    /**
     * 动态规划 dp[i] 表示 输入 i 时， 最大的二叉树个数
     * 则 对于 n =  i+1 , 对于 j in [1,n]，以 j 为根节点, [1, j-1]为左节点，[j+1,n - j]为右节点 的所有二叉树之和
     * dp[i+1] = sum{dp[j-1]*dp{i+1 - j}}, j in [1,i+1]
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new _96_UniqueBinarySearchTrees().numTrees(3));
    }
}
