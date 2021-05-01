package main.java.AmazonFAQ.SlidingWindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FruitsInToBasket {

    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int length = tree.length;
        int left = 0;
        int ans = 0;
        for (int i = 0; i < length; i++) {
            map.put(tree[i], i);
            if (map.size() > 2) {
                int minIndex = Collections.min(map.values());
                map.remove(tree[minIndex]);
                left = minIndex + 1;
            }
            ans = Math.max(ans, i - left + 1);
        }
          return ans;
    }

    public static void main(String[] args) {

    }
}
