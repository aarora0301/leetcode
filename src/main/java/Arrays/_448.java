package main.java.Arrays;;

import java.util.ArrayList;
import java.util.List;


/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */
public class _448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        for (int i = 0; i < nums.length; i++) {

            /**
             * if number is not at its correct position
             * keep it moving until it points to correct position
             */
            if (i + 1 != nums[i]) {
                while (i + 1 != nums[i]) {

                    int start = nums[i];
                    /**
                     * while performing shifts check if number is
                     * placed at correct position
                     */
                    if (start == nums[start - 1]) {
                        break;
                    }
                    nums[i] = nums[start - 1];
                    nums[start - 1] = start;
                }

            }
            /**
             * if number is already at its right position
             */
            else {
                continue;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _448 test = new _448();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(test.findDisappearedNumbers(nums));
    }
}
