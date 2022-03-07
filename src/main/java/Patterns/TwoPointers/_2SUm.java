package Patterns.TwoPointers;

import java.util.HashMap;
import java.util.Map;

/*****
 * https://leetcode.com/problems/two-sum/
 */
public class _2SUm {


    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }

    public static void main(String[] args) {

    }
}
