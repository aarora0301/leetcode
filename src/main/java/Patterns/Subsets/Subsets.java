package Patterns.Subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void backTrack(int[] nums, int start, List<List<Integer>> result, List<Integer> dummy) {
        result.add(new ArrayList<>(dummy));
        for (int i = start; i < nums.length; i++) {
            dummy.add(nums[i]);
            backTrack(nums, i + 1, result, dummy);
            dummy.remove(dummy.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1, 2, 3}));
    }

}
