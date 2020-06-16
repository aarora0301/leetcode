package main.June_LeetCodingChallenge.Week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/****
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this
 * subset satisfies:
 *
 * Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 *
 * Explanation: https://leetcode.com/problems/largest-divisible-subset/discuss/684789/Idea-Explained-or-O(n-2)-time-or-similar-to-LIS
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int num : nums) {
            list.add(new ArrayList<>());
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            List<Integer> maxSubset = new ArrayList<>();
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && maxSubset.size() < list.get(j).size()) {
                    maxSubset = list.get(j);
                }
            }
            list.get(i).addAll(maxSubset);
            list.get(i).add(nums[i]);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (result.size() < list.get(i).size()) {
                result = list.get(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LargestDivisibleSubset test= new LargestDivisibleSubset();
        System.out.println(test.largestDivisibleSubset(new int[]{1,2,3}));
    }

}
