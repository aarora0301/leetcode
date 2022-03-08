package Patterns.Subsets;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(n, k, 1, result, new ArrayList<>());
        return result;
    }

    private void backTrack(int n, int k, int start, List<List<Integer>> result, List<Integer> dummy) {
        if (dummy.size() == k) {
            result.add(new ArrayList<>(dummy));
        }
        for (int i = start; i <= n; i++) {
            dummy.add(i);
            backTrack(n, k, i + 1, result, dummy);
            dummy.remove(dummy.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 2));
    }

}
