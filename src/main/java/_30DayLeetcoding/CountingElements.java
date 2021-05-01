package main.java._30DayLeetcoding;

import java.util.HashMap;
import java.util.Map;

/****
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 *
 * If there're duplicates in arr, count them seperately.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,3]
 * Output: 2
 * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 */
public class CountingElements {

    public static void main(String[] args) {
        CountingElements test = new CountingElements();
        System.out.println(test.countElements(new int[]{1, 1, 2, 2}));
    }

    public int countElements(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int val = 0;
        for (int num : arr) {
            if (map.containsKey(num)) {
                val = map.get(num);
                val += 1;
            } else {
                val = 1;
            }
            map.put(num, val);
        }

        int result = 0;
        for (Map.Entry mapElement : map.entrySet()) {
            int key = (Integer) mapElement.getKey();
            if (map.containsKey(key + 1)) {
                result += map.get(key);
            }
        }
        return result;
    }
}
