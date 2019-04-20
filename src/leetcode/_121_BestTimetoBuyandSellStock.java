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

public class _121_BestTimetoBuyandSellStock {
    /**
     * 标准dp， dp[i] 为0~i最小数
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices == null || prices.length == 0)
            return res;

        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i]);
            res = Math.max(res, prices[i] - dp[i]);
        }

        return res;
    }

    /**
     * 只使用dp[i-1] 故不用保留全部dp数组
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int res = 0;
        if (prices == null || prices.length == 0)
            return res;

        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }

        return res;
    }
}
