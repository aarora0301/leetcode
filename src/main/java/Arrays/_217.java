package main.java.Arrays;

import java.util.Arrays;

/***
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in
 * the array, and it should return false if every element is distinct.
 */
public class _217 {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        _217 test = new _217();
        int[] nums = {906451, 944192, 889932, 164576, 516882};
        System.out.println(test.containsDuplicate(nums));

        //test.containsDuplicate(nums);
    }
}

