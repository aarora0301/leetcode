package main.java.AmazonFAQ.UnionFind;

import java.util.Arrays;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int[] result = new int[2];
        int N = edges.length;
        final UF uf = new UF(N+1);
        for (int[] pairs : edges) {
            if (!uf.connected(pairs[0], pairs[1])) {
                uf.union(pairs[0], pairs[1]);
            } else {
                result = pairs;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        final RedundantConnection rc = new RedundantConnection();
        int[] result = rc.findRedundantConnection(edges);
        System.out.println(Arrays.toString(result));
    }
}
