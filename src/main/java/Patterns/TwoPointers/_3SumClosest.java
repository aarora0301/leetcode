package Patterns.TwoPointers;

import java.util.Arrays;

/*****
 * https://leetcode.com/problems/3sum-closest/
 */
public class _3SumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0, left = 0, right = 0;
        int minSUm = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && minSUm != 0; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < minSUm) {
                    minSUm = target - sum;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return minSUm;

    }

    public static void main(String[] args) {

        int[] arr = new int[]{-2, 0, 1, 3};
        int target = 2;
        int result = threeSumClosest(arr, target);
        System.out.println(result);
    }

}
