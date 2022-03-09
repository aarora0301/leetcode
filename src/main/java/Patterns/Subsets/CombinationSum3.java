package Patterns.Subsets;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, result, new ArrayList<>(), 1, 0);
        return result;
    }

    private void backtrack(int k, int n, List<List<Integer>> result, List<Integer> list, int start, int sum) {
        if (list.size() == k && sum == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            backtrack(k, n, result, list, i + 1, sum + i);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        System.out.println(combinationSum3.combinationSum3(3, 9));
    }

}
