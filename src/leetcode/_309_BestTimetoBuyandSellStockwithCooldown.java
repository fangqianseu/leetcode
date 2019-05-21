/*
Date:05.20,2019 23:00
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like
(ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
*/
package leetcode;

public class _309_BestTimetoBuyandSellStockwithCooldown {
    /**
     * 第i天有3种状态：sell，buy，cooldown
     * buy[i]  = max(cooldown[i-1]-price, buy[i-1])
     * sell[i] = max(buy[i-1]+price, sell[i-1])
     * cooldown[i] = max(sell[i-1], buy[i-1], cooldown[i-1])
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int buy = -prices[0], sell = 0, cooldown = 0;
        for (int i = 1; i < prices.length; i++) {
            int buy0 = buy, sell0 = sell, cooldown0 = cooldown;

            buy = Math.max(cooldown0 - prices[i], buy0);
            sell = Math.max(buy0 + prices[i], sell0);
            cooldown = Math.max(cooldown0, Math.max(sell0, buy0));
        }
        return sell > cooldown ? sell : cooldown;
    }

    public static void main(String[] args) {
        new _309_BestTimetoBuyandSellStockwithCooldown().maxProfit(new int[]{1, 2, 3, 0, 2});
    }
}
