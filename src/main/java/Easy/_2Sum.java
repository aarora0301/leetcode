package main.java.Easy;

import java.util.*;

/***
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class _2Sum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        _2Sum test = new _2Sum();
        int[] arr = test.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(arr));
    }
}
