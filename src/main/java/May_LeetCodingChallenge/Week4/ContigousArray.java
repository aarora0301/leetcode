package main.java.May_LeetCodingChallenge.Week4;

import java.util.HashMap;
import java.util.Map;

/****
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class ContigousArray {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 1) ? 1 : -1;
            if (sum == 0) {
                maxLen = i + 1;
            } else if (hashMap.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - hashMap.get(sum));
            } else {
                hashMap.put(sum, i);
            }
        }
        return maxLen;
    }
}
