/****
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 */
public class MaxConsecutiveOnes {


    public static int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0, maxLength = Integer.MIN_VALUE, windowStart = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
            while (count > k) {
                if (nums[windowStart] == 0) {
                    count--;
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, i - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }

}
