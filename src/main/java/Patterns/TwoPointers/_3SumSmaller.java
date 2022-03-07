package Patterns.TwoPointers;

import java.util.Arrays;

/****
 *  https://leetcode.com/problems/3sum-smaller/
 */
public class _3SumSmaller {

    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int begin = i + 1;
            int end = nums.length - 1;
            while (end > begin) {
                int sum = nums[i] + nums[begin] + nums[end];
                if (sum < target) {
                    count += end - begin;
                    begin++;
                } else {
                    end--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 0, -2};
        int target = 4;
        int result = threeSumSmaller(arr, target);
        System.out.println(result);
    }

}
