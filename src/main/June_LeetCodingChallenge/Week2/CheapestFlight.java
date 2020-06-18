package main.June_LeetCodingChallenge.Week2;

import java.util.Arrays;

public class CheapestFlight {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        double[] minCost = new double[n];
        Arrays.fill(minCost, Double.POSITIVE_INFINITY);
        minCost[src] = 0;
        for (int i = 0; i <= K; i++) {
            /***
             * Unlike Bellman ford travel all vertices
             * in order:
             * 1. travel node that are directly connected to source
             * 2. travel node that can be reached to destination via 1 stop
             * 3. travel node that can be reached to destination via 2 stop
             * 4. travel node that can be reached to destination via k stop and so on
             */
             double[] current= Arrays.copyOf(minCost, n);
            for (int[] edge : flights) {
                int from = edge[0];
                int to = edge[1];
                int cost = edge[2];
                current[to] = Math.min(current[to], minCost[from] + cost);
            }
            minCost= current;
        }
        return minCost[dst] == Double.POSITIVE_INFINITY ? -1 : (int) minCost[dst];
    }

    public static void main(String[] args) {
        CheapestFlight test = new CheapestFlight();
        System.out.println(test.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0));
    }
}
