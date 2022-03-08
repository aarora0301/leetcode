package Patterns.Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    private void backTrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> list, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
        } else if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            backTrack(candidates, target - candidates[i], result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        System.out.println(combinationSum2.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

}
