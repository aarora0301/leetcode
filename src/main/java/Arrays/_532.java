package main.java.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k, you need to find
 * the number of unique k-diff pairs in the array. Here a k-diff
 * pair is defined as an integer pair (i, j), where i and j are
 * both numbers in the array and their absolute difference is k.
 * <p>
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3)
 * and (3, 5).
 * Although we have two 1s in the input, we should only return the
 * number of unique pairs.
 */
public class _532 {

    /**
     * Using Two pointers approach
     *
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /***
     * Using sets
     * @param nums
     * @param k
     * @return
     */
    public int _findPairs(int[] nums, int k) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int count = 0;
        if (k < 0) {
            return 0;
        }
        for (int num : nums) {
            if (k > 0) {
                if ((!set1.contains(num)) && set1.contains(num - k)) {
                    count++;
                }
                if (!set1.contains(num) && set1.contains(num + k)) {
                    count++;
                }
            } else {
                if (set1.contains(num) && !set2.contains(num)) {
                    count++;
                    set2.add(num);
                }
            }
            set1.add(num);
        }
        return count;
    }

    public static void main(String[] args) {
        _532 test = new _532();
        int[] arr = {1, 1, 1, 1, 1};
        int k = 0;
        //System.out.println(test.findPairs(arr, k));
        System.out.println(test._findPairs(arr, k));
    }
}
