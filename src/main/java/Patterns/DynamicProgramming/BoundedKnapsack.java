package Patterns.DynamicProgramming;

import java.util.Arrays;
import java.util.Collections;

public class BoundedKnapsack {

    /****
     * Recursion
     * @param wt
     * @param val
     * @param w
     * @param n
     * @return
     */
    private int knapsack(int[] wt, int[] val, int w, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }
        if (wt[n - 1] <= w) {
            return Math.max(val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1),
                            knapsack(wt, val, w, n - 1));
        } else {
            return knapsack(wt, val, w, n - 1);
        }
    }

    private int knapsack_mem(int[] wt, int[] val, int w, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }
        int[][] t = new int[n + 1][w + 1];
        Arrays.fill(t, -1);

        if (t[n][w] != -1) {
            return t[n][w];
        }
        if (wt[n - 1] <= w) {
            return t[n][w] =
                    Math.max(val[n - 1] + knapsack_mem(wt, val, w - wt[n - 1], n - 1), knapsack_mem(wt, val, w, n - 1));
        } else {
            return t[n][w] = knapsack_mem(wt, val, w, n - 1);
        }
    }


    private int knapsack_dp(int[] wt, int[] val, int w, int n) {
        int[][] t = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
                if (wt[i - 1] <= j) {
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][w];
    }

    public static void main(String[] args) {

    }

}
