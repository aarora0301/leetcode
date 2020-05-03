package main.java._30DayLeetcoding;

/***
 * Given an array of non-negative integers, you are initially positioned at the first index
 * of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int pos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= pos) {
                pos = i;
            }
        }
        return pos == 0;
    }

    public static void main(String[] args) {
        JumpGame test = new JumpGame();
        System.out.println(test.canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
