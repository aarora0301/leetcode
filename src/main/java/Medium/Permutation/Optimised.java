package main.java.Medium.Permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Rumtime: 1 ms
 */
public class Optimised {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        permute(result, sub, nums);
        return result;
    }

    public void permute(List<List<Integer>> result, List<Integer> sub, int[] nums) {
        if (sub.size() == nums.length) {
            result.add(new ArrayList<>(sub));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (sub.contains(nums[i])) {
                continue;
            }
            sub.add(nums[i]);
            permute(result, sub, nums);
            /**
             * Backtrack
             */
            sub.remove(sub.size() - 1);
        }
    }
}
