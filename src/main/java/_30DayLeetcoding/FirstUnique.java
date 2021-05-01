package main.java._30DayLeetcoding;

import java.util.*;


public class FirstUnique {

    Map<Integer, Boolean> map;
    Queue<Integer> queue;

    public FirstUnique(int[] nums) {
        queue = new LinkedList<>();
        map = new HashMap<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        if (!queue.isEmpty()) {
            return queue.peek();
        }
        return -1;
    }

    public void add(int value) {
        if (!map.containsKey(value)) {
            map.put(value, false);
            queue.add(value);
        } else {
            map.put(value, true);
            queue.remove(value);

        }
    }

    public static void main(String[] args) {
        FirstUnique firstUnique = new FirstUnique(new int[]{233, 11});
        System.out.println(firstUnique.showFirstUnique());
    }

}


