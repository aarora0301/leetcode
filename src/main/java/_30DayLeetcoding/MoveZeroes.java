package main.java._30DayLeetcoding;


import java.util.Arrays;

/***
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int i = 0;
        boolean flag = true;
        int startofZero = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                if (flag) {
                    startofZero = i;
                    flag = false;
                    i++;
                    continue;
                } else {
                    startofZero = Math.min(startofZero, i);
                    i++;
                    continue;
                }
            }
            swap(nums, startofZero, i);
            i = Math.min(startofZero, i) + 1;
            startofZero = i;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        MoveZeroes test = new MoveZeroes();
        int[] arr = new int[]{0, 1, 0, 3, 12};
        test.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
