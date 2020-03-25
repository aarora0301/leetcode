package main.java.Arrays;

/***
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class _11 {

    public static void main(String[] args) {
        _11 test = new _11();
        int ans = test.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(ans
        );

    }

    public int maxArea(int[] height) {
        int result = 0;
        int sub = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            sub = Math.min(height[start], height[end]) * (end - start);
            result = Math.max(sub, result);

            if (height[start] < height[end]) {
                start++;
            } else end--;
        }
        return result;
    }
}
