package Patterns.TwoPointers;

/***
 * https://leetcode.com/problems/subarray-product-less-than-k/
 */
public class SubArrayProduct {

    /***
     * TLE
     * @param nums
     * @param k
     * @return
     */

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0, left = 0, right = 0;
        double product = 0;
        for (int i = 0; i < nums.length; i++) {
            left = i;
            product = nums[left];
            while (product < k && left < nums.length) {
                count++;
                left++;
                product *= nums[left];
            }
            if (product < k) {
                count++;
            }
        }
        return count;
    }

    /***
     * Optimised
     * @param nums
     * @param k
     * @return
     */
    public int _numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }
    public static void main(String[] args) {

    }

}
