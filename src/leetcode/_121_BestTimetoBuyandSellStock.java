/*
Date:04.19,2019 23:12
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
*/
package leetcode;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock
and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction.
If you cannot achieve any profit, return 0.

 */
public class _121_BestTimetoBuyandSellStock {
    /**
     *
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        // dp为截止到当天 的最低价
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(prices[i], dp[i - 1]);
            res = Math.max(res, prices[i] - dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        _121_BestTimetoBuyandSellStock bestTimetoBuyandSellStock = new _121_BestTimetoBuyandSellStock();
        System.out.println(bestTimetoBuyandSellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
