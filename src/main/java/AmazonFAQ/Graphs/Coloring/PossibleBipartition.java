package main.java.AmazonFAQ.Graphs.Coloring;

import java.util.ArrayList;
import java.util.List;

/****
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 *
 * Each person may dislike some other people, and they should not go into the same group.
 *
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 *
 * Return true if and only if it is possible to split everyone into two groups in this way.
 *
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 */
public class PossibleBipartition {

    ArrayList[] graph;
    boolean[] color;
    boolean[] isVisited;
    boolean isBipartite;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N + 1];
        isBipartite = true;
        isVisited = new boolean[N + 1];
        color = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] nodes : dislikes) {
            graph[nodes[0]].add(nodes[1]);
            graph[nodes[1]].add(nodes[1]);
        }

        for (int vertex = 1; vertex <= N; vertex++) {
            if (!isVisited[vertex]) {
                dfs(graph, vertex);
            }
        }
        return isBipartite;
    }

    private void dfs(ArrayList[] graph, int vertex) {
        isVisited[vertex] = true;
        List<Integer> neighbours = graph[vertex];
        for (int neighbour : neighbours) {
            if (!isVisited[neighbour]) {
                color[neighbour] = !color[vertex];
                dfs(graph, neighbour);
            } else if (color[neighbour] == color[vertex]) {
                isBipartite = false;
                return;
            }
        }
    }
}
