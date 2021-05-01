package main.java.July_LeetcodingChallenge;

import java.lang.reflect.Array;

/****
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 *
 * Given n, find the total number of full staircase rows that can be formed.
 *
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 *
 * Example 1:
 *
 * n = 5
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * Because the 3rd row is incomplete, we return 2.
 * Approach : https://leetcode.com/articles/arranging-coins/
 */
public class ArrangingCoins {

    public int arrangeCoins(int n) {
        int left = 0;
        int right = n;
        long curr = 0, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            curr = (mid) * (mid + 1) / 2;
            if (curr == n) {
                return (int) (mid);
            }
            if (curr > n) {
                right = (int) mid - 1;
            } else {
                left = (int) mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        ArrangingCoins test = new ArrangingCoins();
        System.out.println(test.arrangeCoins(8));
    }
}
