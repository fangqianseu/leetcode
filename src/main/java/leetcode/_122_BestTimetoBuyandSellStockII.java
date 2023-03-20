/*
Date:05.20,2019 23:16
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like
(i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
*/
package leetcode;

public class _122_BestTimetoBuyandSellStockII {
    /**
     * 多次买卖股票
     * 即求上升序列的和
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0)
                res += prices[i] - prices[i - 1];
        }
        return res;
    }
}
