package Patterns.Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> result, List<Integer> dummy) {
        result.add(new ArrayList<>(dummy));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            dummy.add(nums[i]);
            backtrack(nums, i + 1, result, dummy);
            dummy.remove(dummy.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets2 subsets2 = new Subsets2();
        System.out.println(subsets2.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
