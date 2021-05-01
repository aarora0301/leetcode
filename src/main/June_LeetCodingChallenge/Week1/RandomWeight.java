package main.June_LeetCodingChallenge.Week1;

/*****
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which
 * randomly picks an index in proportion to its weight.
 *
 * Note:
 *
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 * Example 1:
 *
 * Input:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 *
 * Visualization: https://leetcode.com/problems/random-pick-with-weight/discuss/671460/Detailed-Explanation-or-Summary-of-2-different-solutions
 */

public class RandomWeight {
    int[] cumWeight;

    public RandomWeight(int[] w) {
        cumWeight = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            cumWeight[i] = sum;
        }
    }

    public int pickIndex() {
        double target = cumWeight[cumWeight.length - 1] * Math.random();
        for (int i = 0; i < cumWeight.length; i++) {
            if (target < cumWeight[i]) {
                return i;
            }
        }
        return -1;
    }

}