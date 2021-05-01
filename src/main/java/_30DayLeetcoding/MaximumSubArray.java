package main.java._30DayLeetcoding;

import java.util.jar.JarOutputStream;

/***
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        int result = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result + nums[i], nums[i]);
            max = Math.max(result, max);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubArray test = new MaximumSubArray();
        System.out.println(test.maxSubArray(new int[]{1}));
    }
}
