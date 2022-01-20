package main.java.May_LeetCodingChallenge.Week4;

import java.util.ArrayList;
import java.util.List;

/*****
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 *
 * Each person may dislike some other people, and they should not go into the same group.
 *
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 *
 * Return true if and only if it is possible to split everyone into two groups in this way.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 *
 * 1 <= N <= 2000
 * 0 <= dislikes.length <= 10000
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= N
 * dislikes[i][0] < dislikes[i][1]
 * There does not exist i != j for which dislikes[i] == dislikes[j].
 */
public class PossibleBipartition {

   ArrayList<Integer>[] graph;
   boolean[] color;
   boolean[] marked;
   boolean isPartition;

   public boolean possibleBipartition(int N, int[][] dislikes) {
      isPartition = true;
      color = new boolean[N + 1];
      graph = new ArrayList[N + 1];
      marked = new boolean[N + 1];
      for (int i = 1; i <= N; i++) {
         graph[i] = new ArrayList<>();
      }

      for (int[] edge : dislikes) {
         graph[edge[0]].add(edge[1]);
         graph[edge[1]].add(edge[0]);
      }

      for (int vertex = 1; vertex <= N; vertex++) {
         if (!marked[vertex]) {
            dfs(graph, vertex);
         }
      }
      return isPartition;
   }

   private void dfs(ArrayList<Integer>[] graph, int vertex) {
      marked[vertex] = true;
      List<Integer> neighbours = graph[vertex];
      neighbours.forEach(neighbour -> {
         if (!marked[neighbour]) {
            color[neighbour] = !color[vertex];
            dfs(graph, neighbour);
         } else if (color[neighbour] == color[vertex]) {
            isPartition = false;
         }
      });
   }

   public static void main(String[] args) {
      PossibleBipartition test = new PossibleBipartition();
      System.out.println(test.possibleBipartition(5,
            new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 1, 5 } }));
   }

}

