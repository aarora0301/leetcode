import java.sql.Array;
import java.util.*;

public class Solution {

   public static int networkDelayTime(int[][] times, int n, int k) {
      Map<Integer, List<NodeWeight>> graph = new HashMap<>();
      for (int[] edge : times) {
         graph.putIfAbsent(edge[0], new ArrayList<>());
         graph.get(edge[0]).add(new NodeWeight(edge[1], edge[2]));
      }

      PriorityQueue<NodeWeight> pq =
            new PriorityQueue<>(Comparator.comparingInt(NodeWeight::getWeight));

      pq.offer(new NodeWeight(k, 0));
      Map<Integer, Integer> map = new HashMap<>();

      while (!pq.isEmpty()) {
         NodeWeight top = pq.poll();
         if (map.containsKey(top.getNode())) {
            continue;
         }
         map.putIfAbsent(top.getNode(), top.getWeight());
         if (graph.containsKey(top.getNode())) {
            List<NodeWeight> neighbours = graph.get(top.getNode());
            if (neighbours == null) {
               continue;
            }
            for (NodeWeight neighbour : neighbours) {
               if (!map.containsKey(neighbour.getNode())) {
                  pq.offer(new NodeWeight(neighbour.getNode(),
                        neighbour.getWeight() + top.getWeight()));
               }
            }
         }
      }

      if (map.size() != n) {
         return -1;

      }
      int ans = 0;
      for (int weight : map.values()) {
         ans = Math.max(ans, weight);
      }
      return ans;
   }

   public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      if (flights == null) {
         return -1;
      }
      Map<Integer, List<NodeWeight>> graph = new HashMap<>();
      int curr = -1;

      int[] cost= new int[n];

      for (int[] flight : flights) {
         graph.putIfAbsent(flight[0], new ArrayList<>());
         graph.get(flight[0]).add(new NodeWeight(flight[1], flight[2]));

      }

      PriorityQueue<NodeWeight> pq =
            new PriorityQueue<>(Comparator.comparingInt(NodeWeight::getWeight));
      pq.offer(new NodeWeight(src, 0));
      Map<Integer, Integer> isVisted = new HashMap<>();
      int count = -1;

      while (!pq.isEmpty() && k > 0 && count < k + 1) {
         NodeWeight top = pq.poll();

         if (isVisted.containsKey(top.getNode())) {
          continue;
         }
         isVisted.putIfAbsent(top.getNode(), top.getWeight());

         if (graph.containsKey(top.getNode())) {
            List<NodeWeight> neighbours = graph.get(top.getNode());
            if (neighbours == null) {
               continue;
            }
            for (NodeWeight neighbour : neighbours) {
               if (!isVisted.containsKey(neighbour)) {
                  int weight = neighbour.getWeight() + top.getWeight();
                  pq.offer(new NodeWeight(neighbour.getNode(), weight));
               }
            }
         }

      }
      return isVisted.containsKey(dst) ? isVisted.get(dst) : curr;
   }


   public static void main(String[] args) {
      int[][] arr =
            { { 1, 2, 10 }, { 2, 0, 7 }, { 1, 3, 8 }, { 4, 0, 10 }, { 3, 4, 2 }, { 4, 2, 10 },
                  { 0, 3, 3 }, { 3, 1, 6 }, { 2, 4, 5 } };
      int n = 5;
      int src = 0, dst = 4, k = 1;
      int ans = findCheapestPrice(n, arr, src, dst, k);
      System.out.println(ans);
   }

}

class NodeWeight {

   private int node;
   private int weight;

   public NodeWeight(int node, int weight) {
      this.node = node;
      this.weight = weight;
   }

   public int getNode() {
      return node;
   }

   public void setNode(int node) {
      this.node = node;
   }

   public int getWeight() {
      return weight;
   }

   public void setWeight(int weight) {
      this.weight = weight;
   }
}

