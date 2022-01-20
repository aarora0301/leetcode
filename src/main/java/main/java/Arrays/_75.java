package main.java.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort
 * them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color
 * red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for
 * this problem.
 */
public class _75 {

    public void sortColors(int[] nums) {
        int start = 0, mid = 0, end = nums.length - 1;
        int pivot = 1;
        while (mid <= end) {
            if (nums[mid] < pivot) {
                swap(nums, start, mid);
                start++;
                mid++;
            } else if (nums[mid] > pivot) {
                swap(nums, end, mid);
                end--;
            } else {
                mid++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

    }
}
