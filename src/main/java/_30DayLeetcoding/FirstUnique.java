package main.java._30DayLeetcoding;

import java.util.*;


public class FirstUnique {

    Map<Integer, Boolean> map;
    public FirstUnique(int[] nums) {
        map = new HashMap<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        for (Map.Entry<Integer, Boolean> entryMap : map.entrySet()) {
            if (!entryMap.getValue()) {
                return entryMap.getKey();
            }
        }
        return -1;
    }

    public void add(int value) {
        if (!map.containsKey(value)) {
            map.put(value, false);
        } else {
            map.put(value, true);

        }
    }

    public static void main(String[] args) {
        FirstUnique firstUnique = new FirstUnique(new int[]{233, 11, 233});
        System.out.println(firstUnique.showFirstUnique());
    }

}


