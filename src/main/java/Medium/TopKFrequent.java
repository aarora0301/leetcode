package main.java.Medium;

import java.util.*;

public class TopKFrequent {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            result.add(pq.poll().val);
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequent test = new TopKFrequent();
        List<Integer> result = test.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(result.toString());
    }

}

class Node implements Comparable<Node> {
    int val;
    int freq;

    Node(int val, int freq) {
        this.val = val;
        this.freq = freq;
    }

    @Override
    public int compareTo(Node o) {
        /**
         * creates max-heap
         *
         */
        return Integer.compare(this.freq, o.freq);
    }
}