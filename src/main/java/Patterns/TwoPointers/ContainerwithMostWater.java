package Patterns.TwoPointers;

/***
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerwithMostWater {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1, maxArea = Integer.MIN_VALUE;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {

    }

}
