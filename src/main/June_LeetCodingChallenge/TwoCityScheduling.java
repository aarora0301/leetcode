package main.June_LeetCodingChallenge;

import java.util.Arrays;
import java.util.Comparator;

/***
 * There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0],
 * and the cost of flying the i-th person to city B is costs[i][1].
 *
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 *
 *
 *
 * Example 1:
 *
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 *
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 *
 *
 * Note:
 *
 * 1 <= costs.length <= 100
 * It is guaranteed that costs.length is even.
 * 1 <= costs[i][0], costs[i][1] <= 1000
 *
 *
 * Solution https://leetcode.com/problems/two-city-scheduling/discuss/668155/Two-Approach-or-Detailed-Explanation-or-Clean-Code-or-1ms-or
 */
public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        /**
         *  Approach 2
         */
        Arrays.sort(costs, Comparator.comparingInt(p -> (p[0] - p[1])));
        int minCost = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            minCost += costs[i][0]; // send first N to A
            minCost += costs[costs.length / 2 + i][1]; // send last N to B
        }
        return minCost;
    }

    public int _twoCitySchedCost(int[][] costs) {
        int length = costs.length;
        int[] refund = new int[length];
        int minCost = 0, index = 0;
        for (int[] cost : costs) {
            refund[index++] = cost[1] - cost[0];   // Calculate diff, how much we save if we sent all to B
            minCost += cost[0];  // Send all to A
        }
        Arrays.sort(refund); // sort refund array which will have low prices for travelling to city B at top
        for (int i = 0; i < length / 2; i++) {
            minCost += refund[i]; // Add refund/diff for N persons
        }
        return minCost;
    }

}

