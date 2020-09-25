package main.java.AmazonFAQ.Graphs.ShortestPath;

import java.util.Arrays;

public class CheapestFlight {


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        double[] minCost = new double[n];
        Arrays.fill(minCost, Double.POSITIVE_INFINITY);
        minCost[src] = 0;
        for (int i = 0; i <= K; i++) {
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];
                minCost[to] = Math.min(minCost[to], minCost[from] + cost);
            }
        }
        return minCost[dst] == Double.POSITIVE_INFINITY ? -1 : (int) minCost[dst];
    }

    public static void main(String[] args) {

    }
}
