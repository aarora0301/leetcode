package Patterns.Subsets;

/****
 * https://leetcode.com/problems/combination-sum/
 */

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), 0, candidates, target);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> dummy, int start, int[] input, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(dummy));
        }else if (target < 0) {
            return;
        }
        for (int i = start; i < input.length; i++) {
            dummy.add(input[i]);
            backTrack(result, dummy, i, input, target - input[i]);
            dummy.remove(dummy.size()-1);

        }

    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7));

    }

}
