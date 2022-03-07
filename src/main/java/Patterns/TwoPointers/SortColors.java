package Patterns.TwoPointers;

/****
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int curr = 0;
        while (curr < right) {
            if (nums[curr] == 0) {
                swap(nums, curr, left);
                curr++;
                left++;
            } else if (nums[curr] == 2) {
                swap(nums, curr, right);
                right--;
            } else {
                curr++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

    }

}
