package main.java._30DayLeetcoding;

import java.util.HashMap;
import java.util.Map;

/*****
 * Best Time to Buy and Sell Stock II
 * Solution
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3
 */
public class BestTimeToBuyAndSell {

    public int maxProfit(int[] prices) {
        int result = 0;
        int len = prices.length;
        for (int i = 0; i < len - 1; i++) {
            if (prices[i] > prices[i + 1]) {
                continue;
            }
            result += prices[i + 1] - prices[i];
        }
        return result;

    }

    public static void main(String[] args) {
        BestTimeToBuyAndSell test = new BestTimeToBuyAndSell();
        System.out.println(test.maxProfit(new int[]{2, 1, 2, 1, 0, 0, 1}));
    }
}
