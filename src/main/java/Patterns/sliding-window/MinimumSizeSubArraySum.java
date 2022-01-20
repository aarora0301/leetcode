/****
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */

public class MinimumSizeSubArraySum {


    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0 || target == 0) {
            return 0;
        }

        int sum = 0;
        int windowLength = Integer.MAX_VALUE;
        int windowStart = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                windowLength = Math.min(windowLength, i - windowStart + 1);
                sum -= nums[windowStart];
                windowStart++;
            }
        }
        return windowLength == Integer.MAX_VALUE ? 0 : windowLength;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

}
