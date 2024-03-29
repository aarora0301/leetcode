package Patterns.TwoPointers;

/****
 * https://leetcode.com/problems/trapping-rain-water/solution/
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int ans = 0;
        left[0] = height[0];
        right[n] = height[n-1];

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        for (int i = n - 2; i > 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
