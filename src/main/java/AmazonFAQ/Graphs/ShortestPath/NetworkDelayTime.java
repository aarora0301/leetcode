package main.java.AmazonFAQ.Graphs.ShortestPath;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        pq.add(new int[]{0, K});
        int res = 0;
        boolean[] isVisited = new boolean[N + 1];
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int currDist = top[0];
            int currNode = top[1];
            if (isVisited[currNode]) continue;

            isVisited[currNode] = true;
            res = currDist;
            N--;
            if (N <= 0) {
                break;
            }
            /**
             *   fetch all the child nodes and add them to QUeue
             *   this is just like BFS, rather than using normal queue we are using PriorityQueue
             *   as wwe need to fetch distance
             */
            if (map.containsKey(currNode)) {
                for (int neighbour : map.get(currNode).keySet()) {
                    pq.add(new int[]{currDist + map.get(currNode).get(neighbour), neighbour});
                }
            }
        }
        return N == 0 ? res : -1;

    }

    public static void main(String[] args) {

    }
}
