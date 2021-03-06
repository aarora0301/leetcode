package main.java.AmazonFAQ.Graphs.UnionFind;

import java.util.Arrays;

/****
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 *
 * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added.
 * The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 *
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected
 * edge connecting nodes u and v.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer
 * that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.
 *
 *
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given undirected graph will be like this:
 *   1
 *  / \
 * 2 - 3
 * Example 2:
 * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * Output: [1,4]
 */

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int[] result = new int[2];
        int N = edges.length;
        final UF uf = new UF(N + 1);
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
