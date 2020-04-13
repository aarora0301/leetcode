package main.java._30DayLeetcoding;

import java.util.*;

/****
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */
public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0, count = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxLength = Math.max(maxLength, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        ContiguousArray test = new ContiguousArray();
        System.out.println(test.findMaxLength(new int[]{0, 1, 1, 0}));
    }
}


