package main.java;

import java.util.HashMap;
import java.util.Map;

class Solution {

    // {1, 1, 5, 1, 3, 2, 4, 5, 6})
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = sol.getElement(new int[]{1, 2, 5, 1, 6, 6}); // count>1
        System.out.println(ans);

        ans = sol.getElement(new int[]{1, 3, 2, 4, 5, 6}); // --- 0
        System.out.println(ans);
    }


    private int getElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int minDistance = Integer.MAX_VALUE;
        int result = 0;
        Map<Integer, Value> map = new HashMap<>();
        Value val;
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                val = new Value(i, 0, 1);
            } else {
                val = map.get(arr[i]);
                val.currDistance = i - val.startIndex + 1;
                val.startIndex = i;
                int count = val.count + 1;
                val.count = count;
            }

            map.put(arr[i], val);

            if (val.count == 1 && minDistance == Integer.MAX_VALUE) {
                result = 0;
            } else if (val.count > 1 && val.currDistance < minDistance) {
                result = arr[i];
                minDistance = val.currDistance;
            }
        }
        return result;
    }
}


class Value {
    int startIndex;
    int currDistance;
    int count;

    public Value(int start, int curr, int count) {
        startIndex = start;
        currDistance = curr;
        this.count = count;

    }
}
