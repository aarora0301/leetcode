package main.java._30DayLeetcoding;

import java.util.HashMap;
import java.util.Map;

/***
 * Given an array of integers and an integer k, you need to find the total number of continuous
 * sub arrays whose sum equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class SubArraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (hashMap.containsKey(sum - k)) {
                count += hashMap.get(sum - k);
            } else {
                hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SubArraySumEqualsK test = new SubArraySumEqualsK();
        System.out.println(test.subarraySum(new int[]{1, 0, 1}, 2));
    }
}
