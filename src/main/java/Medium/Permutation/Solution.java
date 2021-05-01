package main.java.Medium.Permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * 46 : Permutations
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * Hint : Backtracking
 */
public class Solution {

    /***
     * Runtime: 5ms
     */

    int left = 0;
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> sub;

    public List<List<Integer>> permute(int[] nums) {
        if (left == nums.length - 1) {
            List<Integer> sub = Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.toList());
            result.add(sub);
            return result;
        } else {
            for (int i = left; i <= nums.length - 1; i++) {
                swap(nums, left, i);
                left = left + 1;
                permute(nums);
                /**
                 * backtrack
                 */
                left = left - 1;
                swap(nums, left, i);
            }
        }
        return result;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        List<List<Integer>> res = test.permute(new int[]{1, 2, 3});
        Stream.of(res)
                .flatMap(Stream::of)
                .forEach(System.out::println);
    }
}
